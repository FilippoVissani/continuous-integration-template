ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "it.unibo"
ThisBuild / scalaVersion := "3.2.0-RC2"

lazy val root = (project in file("."))
  .settings(
    name := "ci-test",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12" % Test
  )

wartremoverWarnings ++= Warts.unsafe

coverageFailOnMinimum := true
coverageMinimumStmtTotal := 90
coverageMinimumBranchTotal := 90
coverageMinimumStmtPerPackage := 90
coverageMinimumBranchPerPackage := 85
coverageMinimumStmtPerFile := 85
coverageMinimumBranchPerFile := 80