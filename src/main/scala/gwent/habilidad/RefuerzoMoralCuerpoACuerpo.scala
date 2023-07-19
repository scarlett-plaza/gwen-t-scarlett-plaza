package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.{CuerpoACuerpoCard, Card}
/**
 * RefuerzoMoralCuerpoACuerpo represents the ability of a card to increase the power of CuerpoACuerpo card.
 * It extends the Habilidad class.
 *
 * @param valor The value of the reinforcement.
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
class RefuerzoMoralCuerpoACuerpo(val valor: Int) extends Habilidad{
  /**
   * Applies the ability to the target card.
   *
   * @param self   The card that has the ability.
   * @param target The card that will be affected by the ability.
   */
  override def apply(self: Card, target: Card): Unit = {
    aplicar(self.asInstanceOf[CuerpoACuerpoCard], target.asInstanceOf[CuerpoACuerpoCard])
  }

  /**
   * Applies the RefuerzoMoralADistancia ability to a target CuerpoACuerpoCard.
   * It increases the current power of the target card by the specified value.
   *
   * @param self   The CuerpoACuerpoCard associated with the ability.
   * @param target The target CuerpoACuerpoCard to apply the ability to.
   */
  def aplicar(self: CuerpoACuerpoCard, target: CuerpoACuerpoCard): Unit = {
    target.currentPower += valor
  }
}
