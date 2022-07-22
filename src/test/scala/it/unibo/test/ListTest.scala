package it.unibo.test

import it.unibo.test.List.length
import org.scalatest.funsuite.AnyFunSuite

class ListTest extends AnyFunSuite:
  test("List")(assert(length(List(1)) == 1))
