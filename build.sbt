val scala3Version = "3.2.2"

ThisBuild / sonatypeCredentialHost := "s01.oss.sonatype.org"

lazy val root = (project in file("."))
  .settings(
    name := "continuous-integration-template",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    publishTo := sonatypePublishToBundle.value,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.16" % Test,
    assembly / mainClass := Some("io.github.filippovissani.continuous_integration_template.Main"),
    assembly / assemblyJarName := "continuous-integration-template.jar",
    assembly / test := (Test / test).value,
)
