package it.unibo.test

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class CubeCalculatorTest extends AnyFlatSpec with should.Matchers:

  "A cube with side size = 3" should "have volume = 27" in {
    CubeCalculator.cube(3) should be (27)
  }

/*  "A square with side size = 3" should "have area = 9" in {
    CubeCalculator.square(3) should be (9)
  }

  "An hypercube with side size = 3 and 5 dimensions" should "have volume = 243" in {
    CubeCalculator.hypercube(3, 5) should be (243)
  }*/
