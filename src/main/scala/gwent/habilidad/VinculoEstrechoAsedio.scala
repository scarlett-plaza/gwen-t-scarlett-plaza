package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.{AsedioCard, Card}

class VinculoEstrechoAsedio() extends Habilidad {
  override def apply(self: Card, target: Card): Unit = {
    aplicar(self.asInstanceOf[AsedioCard], target.asInstanceOf[AsedioCard])
  }
  def aplicar(self: AsedioCard, target: AsedioCard): Unit = {
    self.currentPower = 2* self.currentPower
    target.currentPower = 2* target.currentPower
  }
}
