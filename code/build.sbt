name := "Sharing Is Caring Talk"

scalaVersion := "2.12.4"

val buildSettings = Defaults.coreDefaultSettings ++ List(
  scalaVersion := "2.12.4"
)

lazy val json = (project in file("json"))
  .settings(buildSettings)

lazy val macros = (project in file("macros"))
  .settings(
    buildSettings ++ List(
      libraryDependencies ++= List(
        "org.scala-lang" % "scala-reflect" % scalaVersion.value
      )
    )
  ).dependsOn(json)

lazy val root = (project in file("."))
  .settings(buildSettings)
  .dependsOn(json, macros)