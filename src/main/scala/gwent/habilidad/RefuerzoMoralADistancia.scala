package cl.uchile.dcc
package gwent.habilidad


import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.board.sections.Section
import cl.uchile.dcc.gwent.cards.{ADistanciaCard, Card}
//
class RefuerzoMoralADistancia(val valor: Int) extends Habilidad{
  override def apply(self: Card, target: Card): Unit = {
     aplicar(self.asInstanceOf[ADistanciaCard], target.asInstanceOf[ADistanciaCard])
  }
  
  def aplicar(self: ADistanciaCard, target: ADistanciaCard): Unit = {
    target.currentPower += valor
  }
}
