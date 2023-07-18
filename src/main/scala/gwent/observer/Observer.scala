package cl.uchile.dcc
package gwent.observer

trait Observer {
  def update(observable: ISubject, arg:Any):Unit
}
