package it.unibo.test

import it.unibo.test.Option.*
import it.unibo.test.Option
import scala.annotation.tailrec

enum List[E]:
  case Cons(head: E, tail: List[E])
  case Nil()

object List:
  def sum(l: List[Int]): Int = l match
    case Cons(h, t) => h + sum(t)
    case _ => 0

  def map[A, B](l: List[A])(mapper: A => B): List[B] = l match
    case Cons(h, t) => Cons(mapper(h), map(t)(mapper))
    case Nil() => Nil()

  def flatMap[A, B](list: List[A])(f: A => List[B]): List[B] = list match
    case Cons(head, rest) => append(f(head), flatMap(rest)(f))
    case _ => Nil()

  def filter[A](l1: List[A])(pred: A => Boolean): List[A] = l1 match
    case Cons(h, t) if pred(h) => Cons(h, filter(t)(pred))
    case Cons(_, t) => filter(t)(pred)
    case Nil() => Nil()

  @tailrec
  def drop[A](list: List[A], n: Int): List[A] = (n, list) match
    case (0, l) => l
    case (n, List.Cons(_, tail)) => drop(tail, n - 1)
    case _ => list

  def append[A](left: List[A], right: List[A]): List[A] = left match
    case Cons(head, rest) => Cons(head, append(rest, right))
    case Nil() => right

  @tailrec
  def foldLeft[A, B](list: List[A])(init: B)(f: (B, A) => B): B = list match
    case Nil() => init
    case Cons(h, t) => foldLeft(t)(f(init, h))(f)

  def reverse[A](list: List[A]): List[A] = foldLeft(list)(Nil())((a, f) => Cons(f, a))

  def foldRight[A, B](list: List[A])(init: B)(f: (A, B) => B): B =
    foldLeft(reverse(list))(init)((acc, v) => f(v, acc))

  def length(list: List[_]): Int = List.sum(List.map(list)(_ => 1))

  @tailrec
  def find[A](list: List[A])(f: A => Boolean): Option[A] = list match
    case Cons(elem, rest) if f(elem) => Some(elem)
    case Cons(elem, rest) => find(rest)(f)
    case _ => None()

  def contains[A](list: List[A], elem: A): Boolean = !Option.isEmpty(find(list)(_ == elem))

  def remove[A](list: List[A])(f: A => Boolean): List[A] = list match
    case Cons(elem, rest) if f(elem) => rest
    case Cons(elem, rest) => Cons(elem, remove(rest)(f))
    case _ => Nil()

  def take[A](list: List[A], n: Int): List[A] = reverse(drop(reverse(list), length(list) - n))

  def apply[A](elements: A*): List[A] =
    var list: List[A] = Nil()
    elements.foreach(e => list = append(list, Cons(e, Nil())))
    list

end List
