package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.{ADistanciaCard, Card}

class VinculoEstrechoADistancia() extends Habilidad {
  override def apply(self: Card, target: Card): Unit = {
    aplicar(self.asInstanceOf[ADistanciaCard], target.asInstanceOf[ADistanciaCard])
  }
  def aplicar(self: ADistanciaCard, target: ADistanciaCard): Unit = {
    self.currentPower = 2* self.currentPower
    target.currentPower = 2* target.currentPower
  }
}
