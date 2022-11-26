package io.github.filippovissani.continuous_integration_template

object CubeCalculator:

  def square(x: Int): Int = x * x

  def cube(x: Int): Int = x * x * x

  def hypercube(x: Int, dimensions: Int): Int = Math.pow(x, dimensions).toInt
