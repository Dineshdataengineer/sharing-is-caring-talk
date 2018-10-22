name := "sharing-is-caring-talk"

val commonSettings = List(scalaVersion := "2.12.7")

lazy val json = project
  .settings(commonSettings)

lazy val macros = project
  .settings(
    commonSettings ++ List(
      libraryDependencies ++= List(
        "org.scala-lang" % "scala-reflect" % scalaVersion.value
      )
    )
  ).dependsOn(json)

lazy val core = project
  .settings(commonSettings)
  .dependsOn(json, macros)