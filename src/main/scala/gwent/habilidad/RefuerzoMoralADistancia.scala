package cl.uchile.dcc
package gwent.habilidad


import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.board.sections.Section
import cl.uchile.dcc.gwent.cards.{ADistanciaCard, Card}
/**
 * RefuerzoMoralADistancia represents the ability of a Adistancia card to increase the power of a card ADistancia in valor.
 * It extends the Habilidad class.
 *
 * @param valor The value of the reinforcement.
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
class RefuerzoMoralADistancia(val valor: Int) extends Habilidad{
  /**
   * Applies the RefuerzoMoralADistancia ability to a target card.
   *
   * @param self   The card on which the ability is being applied.
   * @param target The target card to apply the ability to.
   */
  override def apply(self: Card, target: Card): Unit = {
     aplicar(self.asInstanceOf[ADistanciaCard], target.asInstanceOf[ADistanciaCard])
  }

  /**
   * Applies the RefuerzoMoralADistancia ability to a target ADistanciaCard.
   * It increases the current power of the target card by the specified value.
   *
   * @param self   The ADistanciaCard associated with the ability.
   * @param target The target ADistanciaCard to apply the ability to.
   */
  def aplicar(self: ADistanciaCard, target: ADistanciaCard): Unit = {
    target.currentPower += valor
  }
}
