import SonatypeKeys._

sonatypeSettings

// Turn this project into a Scala.js project by importing these settings
enablePlugins(ScalaJSPlugin)

organization := "eu.unicredit"

name := "paths-scala-js"

version := "0.4.2"

scalaVersion := "2.11.7"

persistLauncher in Compile := true

persistLauncher in Test := false

testFrameworks += new TestFramework("utest.runner.Framework")

jsDependencies += "org.webjars.bower" % "paths-js" % "0.4.2" / "paths.js"

skip in packageJSDependencies := false

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-language:reflectiveCalls"
)

publishMavenStyle := true

pomIncludeRepository := { x => false }

credentials += Credentials(Path.userHome / ".ivy2" / "sonatype.credentials")

pomExtra := {
  <url>https://github.com/andreaferretti/paths-scala-js</url>
  <licenses>
    <license>
      <name>Apache 2</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
    </license>
  </licenses>
  <scm>
    <connection>scm:git:github.com/andreaferretti/paths-scala-js</connection>
    <developerConnection>scm:git:git@github.com:andreaferretti/paths-scala-js</developerConnection>
    <url>github.com/andreaferretti/paths-scala-js</url>
  </scm>
  <developers>
    <developer>
      <id>andreaferretti</id>
      <name>Andrea Ferretti</name>
      <url>https://github.com/andreaferretti/</url>
    </developer>
  </developers>
}