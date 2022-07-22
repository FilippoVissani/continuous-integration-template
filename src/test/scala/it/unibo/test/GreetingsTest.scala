package it.unibo.test

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class GreetingsTest extends AnyFlatSpecLike with Matchers {

  behavior.of("greetings class")

  it should "print greetings" in {
    Greetings.printGreeting() shouldEqual "Hello world!"
  }

  it should "compute addition" in {
    Greetings.addSomeNumbers() shouldEqual 12
  }

}
