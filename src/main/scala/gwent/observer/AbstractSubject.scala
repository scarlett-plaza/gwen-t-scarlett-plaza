package cl.uchile.dcc
package gwent.observer

import scala.collection.mutable.ListBuffer
/**
 * AbstractSubject is an abstract class that implements the ISubject trait.
 * It provides an implementation for managing observers and notifying them of updates.
 *
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
abstract class AbstractSubject extends ISubject {
  private var observers: List[Observer] = Nil

  /**
   * Adds an observer to the list of observers.
   * @param observer
   */
  override def addObserver(observer: Observer): Unit = {
    observers = observer :: observers
  }

  /**
   * Notifies all observers of an update.
   * @param response
   */
  override def notifyObservers(response: Any): Unit = {
    for (observer <- observers) {
      observer.update(this, response)
    }
  }

}
