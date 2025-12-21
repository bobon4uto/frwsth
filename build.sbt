val scala3Version = "3.7.4"
lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "frwsth",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    // for an application with a main method
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.8.1"
    // libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test
  )
/*
lazy val root = project
  .in(file("."))
  .settings(
    name := "frwsth",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test
  )*/
