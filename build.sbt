ThisBuild / sonatypeCredentialHost := "s01.oss.sonatype.org"
sonatypeRepository := "https://s01.oss.sonatype.org/service/local"

inThisBuild(
  List(
    organization := "io.github.filippovissani",
    sonatypeProfileName := "io.github.filippovissani", // Your profile name of the sonatype account
    Test / publishArtifact := false,
    pomIncludeRepository := { _ => false }, // no repositories show up in the POM file
    licenses := Seq("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0")),
    homepage := Some(url("https://filippovissani.github.io/")),
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/FilippoVissani/continuous-integration-template"),
        "scm:git:git@github.org:FilippoVissani/continuous-integration-template.git"
      )
    ),
    developers := List(
      Developer(
        id = "FilippoVissani",
        name = "Filippo Vissani",
        email = "filippo.vissani@studio.unibo.it",
        url = url("https://filippovissani.github.io")
      )
    ),
    scalaVersion := "3.3.0",
  )
)

lazy val root = (project in file("."))
  .settings(
    name := "continuous-integration-template",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.16" % Test,
    assembly / mainClass := Some("io.github.filippovissani.continuous_integration_template.Main"),
    assembly / assemblyJarName := "continuous-integration-template.jar",
    assembly / test := (Test / test).value,
)
