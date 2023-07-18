package cl.uchile.dcc
package gwent.observer

import scala.collection.mutable.ListBuffer

abstract class AbstractSubject extends ISubject {
  private var observers: List[Observer] = Nil

  override def addObserver(observer: Observer): Unit = {
    observers = observer :: observers
  }

  override def notifyObservers(response: Any): Unit = {
    for (observer <- observers) {
      observer.update(this, response)
    }
  }

}
