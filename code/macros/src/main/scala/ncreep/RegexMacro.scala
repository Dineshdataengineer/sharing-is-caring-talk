package ncreep

import language.experimental.macros

import reflect.macros.blackbox.Context
import scala.util.matching.Regex
import scala.util.{ Success, Failure }

object RegexMacro {
  def regex(literal: String): Regex = macro regexImpl

  def regexImpl(c: Context)(literal: c.Expr[String]): c.Expr[Regex] = {
    import c.universe._

    def abort(message: String) = c.abort(c.enclosingPosition, message)

    val stringLiteral = literal.tree match {
      case q"${ s: String }" => s
      case _ => abort("Only string literals can be parsed as regex")
    }

    util.Try(stringLiteral.r) match {
      case Success(_) => ()
      case Failure(t) => abort(s"Failed compiling a regex: ${t.getMessage}")
    }

    c.Expr[Regex](q"$stringLiteral.r")
  }
}