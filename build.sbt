ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

ThisBuild / coverageEnabled := true

lazy val root = (project in file("."))
  .settings(
    name := "ci-test",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.11" % Test
  )

wartremoverErrors ++= Warts.unsafe
