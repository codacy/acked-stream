name := "acked-streams"

organization := "com.codacy"

scalaVersion := "2.13.10"

crossScalaVersions := Seq("2.12.17", "2.13.10")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream"  % "2.5.31",
  "org.scalatest"     %% "scalatest"    % "3.1.1" % "test")

Compile / scalacOptions ++=
  (CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, x)) if x < 13 => "-language:higherKinds" :: Nil
    case _ => Nil
  })

homepage := Some(url("https://github.com/timcharper/acked-stream"))

licenses := Seq("Apache 2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

scmInfo := Some(
  ScmInfo(url("https://github.com/codacy/acked-stream"), "scm:git@github.com:codacy/acked-stream.git")
)

Test / publishArtifact := false

publicMvnPublish

// this setting is not picked up properly from the plugin
pgpPassphrase := Option(System.getenv("SONATYPE_GPG_PASSPHRASE")).map(_.toCharArray)

Compile / doc / sources := Seq.empty
