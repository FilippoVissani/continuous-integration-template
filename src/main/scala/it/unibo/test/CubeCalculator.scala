package it.unibo.test

object CubeCalculator:

  def square(x: Int): Int = x * x

  def cube(x: Int): Int = x * x * x

  def hypercube(x: Int, dimensions: Int): Int = Math.pow(x, dimensions).toInt
