package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.{CuerpoACuerpoCard, Card}

class RefuerzoMoralCuerpoACuerpo(val valor: Int) extends Habilidad{
  override def apply(self: Card, target: Card): Unit = {
    aplicar(self.asInstanceOf[CuerpoACuerpoCard], target.asInstanceOf[CuerpoACuerpoCard])
  }

  def aplicar(self: CuerpoACuerpoCard, target: CuerpoACuerpoCard): Unit = {
    target.currentPower += valor
  }
}
