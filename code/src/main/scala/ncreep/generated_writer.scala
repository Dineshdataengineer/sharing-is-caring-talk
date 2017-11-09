package ncreep

import Json._
import WriterMacro.makeWriter

case class Terminator(name: String,
                      ammo: Option[Int],
                      dangerous: Boolean)

object Terminator {
  val manualWriter = new Writer[Terminator] {
    def write(terminator: Terminator): Json =
      JsObject {
        List(
          "name" -> Json.write(terminator.name),
          "ammo" -> Json.write(terminator.ammo),
          "dangerous" -> Json.write(terminator.dangerous)
        )
      }
  }
  
  implicit val writer: Writer[Terminator] = makeWriter[Terminator] 
}