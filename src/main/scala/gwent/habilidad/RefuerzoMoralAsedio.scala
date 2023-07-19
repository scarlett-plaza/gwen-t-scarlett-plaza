package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.{AsedioCard, Card}
/**
 * RefuerzoMoralAsedio represents the ability of a card to increase the power of Asedio card.
 * It extends the Habilidad class.
 *
 * @param valor The value of the reinforcement.
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
class RefuerzoMoralAsedio(val valor: Int) extends Habilidad{
  /**
   * Applies the ability to the target card.
   *
   * @param self The card that has the ability.
   * @param target The card that will be affected by the ability.
   */
  override def apply(self: Card, target: Card): Unit = {
    aplicar(self.asInstanceOf[AsedioCard], target.asInstanceOf[AsedioCard])
  }

  /**
   * Applies the RefuerzoMoralADistancia ability to a target ASedioCard.
   * It increases the current power of the target card by the specified value.
   *
   * @param self   The AsedioCard associated with the ability.
   * @param target The target AsedioCard to apply the ability to.
   */
  def aplicar(self: AsedioCard, target: AsedioCard): Unit = {
    target.currentPower += valor
  }
}
