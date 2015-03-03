import SonatypeKeys._

sonatypeSettings

// Turn this project into a Scala.js project by importing these settings
enablePlugins(ScalaJSPlugin)

organization := "eu.unicredit"

name := "paths-scala-js"

version := "0.3.2-SNAPSHOT"

scalaVersion := "2.11.5"

persistLauncher in Compile := true

persistLauncher in Test := false

testFrameworks += new TestFramework("utest.runner.Framework")

jsDependencies += "org.webjars" % "paths-js" % "0.3.2" / "paths.js"

skip in packageJSDependencies := false

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-language:reflectiveCalls"
)

publishMavenStyle := true

pomIncludeRepository := { x => false }

credentials += Credentials(Path.userHome / ".ivy2" / "sonatype.credentials")