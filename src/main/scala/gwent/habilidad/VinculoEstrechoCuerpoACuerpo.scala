package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.{CuerpoACuerpoCard, Card}

class VinculoEstrechoCuerpoACuerpo() extends Habilidad {
  override def apply(self: Card, target: Card): Unit = {
    aplicar(self.asInstanceOf[CuerpoACuerpoCard], target.asInstanceOf[CuerpoACuerpoCard])
  }
  def aplicar(self: CuerpoACuerpoCard, target: CuerpoACuerpoCard): Unit = {
    self.currentPower = 2* self.currentPower
    target.currentPower = 2* target.currentPower
  }
}
