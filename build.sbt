// Turn this project into a Scala.js project by importing these settings
enablePlugins(ScalaJSPlugin)

name := "paths-scala-js"

version := "0.3.2"

scalaVersion := "2.11.5"

persistLauncher in Compile := true

persistLauncher in Test := false

testFrameworks += new TestFramework("utest.runner.Framework")

skip in packageJSDependencies := false

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-language:reflectiveCalls"
)
