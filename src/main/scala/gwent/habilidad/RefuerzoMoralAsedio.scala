package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.{AsedioCard, Card}

class RefuerzoMoralAsedio(val valor: Int) extends Habilidad{
  override def apply(self: Card, target: Card): Unit = {
    aplicar(self.asInstanceOf[AsedioCard], target.asInstanceOf[AsedioCard])
  }

  def aplicar(self: AsedioCard, target: AsedioCard): Unit = {
    target.currentPower += valor
  }
}
