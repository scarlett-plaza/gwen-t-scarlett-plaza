package cl.uchile.dcc
package gwent.observer

import scala.collection.mutable.ListBuffer

trait ISubject {
  def addObserver(observer: Observer): Unit
  def notifyObservers(response: Any): Unit
}
