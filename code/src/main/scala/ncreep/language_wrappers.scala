package ncreep

case class HTMLCode(value: String)
case class JSCode(value: String)
case class URLCode(value: String)

case class TaintedHTMLCode(value: String)
case class TaintedJSCode(value: String)
case class TaintedURLCode(value: String)

case class SafeHTMLCode(value: String)
case class SafeJSCode(value: String)
case class SafeURLCode(value: String)

case class SensitiveTaintedHTMLCode(value: String)
case class SensitiveTaintedJSCode(value: String)
case class SensitiveTaintedURLCode(value: String)

case class SensitiveSafeHTMLCode(value: String)
case class SensitiveSafeJSCode(value: String)
case class SensitiveSafeURLCode(value: String)

case class AnonymizedTaintedHTMLCode(value: String)
case class AnonymizedTaintedJSCode(value: String)
case class AnonymizedTaintedURLCode(value: String)

case class AnonymizedSafeHTMLCode(value: String)
case class AnonymizedSafeJSCode(value: String)
case class AnonymizedSafeURLCode(value: String)  