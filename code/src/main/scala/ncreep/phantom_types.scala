package ncreep

import Language._
import Safety._

sealed trait Language

object Language {
  trait HTML extends Language
  trait JS extends Language
  trait URL extends Language
}

sealed trait Safety

object Safety {
  trait Tainted extends Safety
  trait Safe extends Safety
}

case class InputCode[L <: Language, S <: Safety](value: String)

case class Code[L <: Language](value: String)

object PhantomTypes {
  def readHTMLInput(): InputCode[HTML, Tainted] = ???

  def sanitizeHTML(input: InputCode[HTML, Tainted]): InputCode[HTML, Safe] = ???

  def interpolate(input: InputCode[HTML, Safe]): Code[HTML] = ???

  def anonymize[S <: Safety](input: InputCode[HTML, S]): InputCode[HTML, S] = ???
}