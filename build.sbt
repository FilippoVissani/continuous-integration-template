ThisBuild / organization := "io.github.rustfields"
ThisBuild / scalaVersion := "3.2.2"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / sonatypeCredentialHost := "s01.oss.sonatype.org"

lazy val root = (project in file("."))
  .settings(
    name := "continuous-integration-template",
    publishTo := sonatypePublishToBundle.value,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.16" % Test,
    assembly / mainClass := Some("io.github.filippovissani.continuous_integration_template.Main"),
    assembly / assemblyJarName := "continuous-integration-template.jar",
    assembly / test := (Test / test).value,
)

credentials += Credentials(
  "GnuPG Key ID",
  "gpg",
  "75792BDCABA9F241CD0FE833BC26FFD38D9B20FF",
  "ignored"
)
