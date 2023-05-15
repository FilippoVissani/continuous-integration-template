sonatypeProfileName := "io.github.filippovissani"
publishMavenStyle := true
licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))
homepage := Some(url("https://filippovissani.github.io"))
scmInfo := Some(
  ScmInfo(
    url("https://github.com/FilippoVissani/continuous-integration-template"),
    "scm:git@github.com:FilippoVissani/continuous-integration-template.git"
  )
)
developers := List(
  Developer(id="FilippoVissani", name="Filippo Vissani", email="filippo.vissani@studio.unibo.it", url=url("https://filippovissani.github.io/")),
)