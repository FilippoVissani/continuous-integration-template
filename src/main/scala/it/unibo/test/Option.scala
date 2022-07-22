package it.unibo.test

enum Option[A]:
  case Some(a: A)
  case None() // here parens are needed because of genericity

object Option:

  def isEmpty[A](opt: Option[A]): Boolean = opt match
    case None() => true
    case _ => false

  def orElse[A, B >: A](opt: Option[A], orElse: B): B = opt match
    case Some(a) => a
    case _ => orElse

  def flatMap[A, B](opt: Option[A])(f: A => Option[B]): Option[B] = opt match
    case Some(a) => f(a)
    case _ => None()
