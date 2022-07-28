package it.unibo.test

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class MainTest extends AnyFlatSpec with should.Matchers:

  "Main" should "call all CubeCalculator methods" in {
    Main.main(Array())
  }
