package ncreep

import language.experimental.macros

import reflect.macros.blackbox.Context

object WriterMacro {
  def makeWriter[A]: Writer[A] = macro makeWriterImpl[A]

  def makeWriterImpl[A: c.WeakTypeTag](c: Context): c.Expr[Writer[A]] = {
    import c.universe._

    val tpe = weakTypeOf[A]

    def getFields(tpe: Type) = {
      val symbols = tpe.decls.collectFirst {
        case m: MethodSymbol if m.isPrimaryConstructor => m
      }.get.paramLists.head // unsafe calls to get and head, only for illustration purposes
      
      symbols.map(_.name.toTermName)
    }

    val fields: List[TermName] = getFields(tpe)

    val fieldWriters: List[Tree] = fields.map { field =>
      // in a more real scenario, the field name should probably be decoded
      q"${field.toString} -> ncreep.Json.write(value.$field)"
    }

    c.Expr[Writer[A]] {
      q"""
        new ncreep.Writer[$tpe] {
          def write(value: $tpe): ncreep.Json = ncreep.Json.JsObject {
            List(..$fieldWriters)
          }
        }
      """
    }
  }
}