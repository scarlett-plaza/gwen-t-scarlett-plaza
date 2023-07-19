package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.Card
/**
 * NullHabilidad represents a null ability that does not apply any effect to cards.
 * It extends the Habilidad class.
 * This class is used when no specific ability is assigned to a card.
 * It serves as a placeholder for cards without an active ability.
 *
 * Note: This class overrides the apply method to provide an empty implementation.
 *
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
class NullHabilidad() extends Habilidad{
  /**
   * Applies the null ability to the target card.
   * This method does not have any effect.
   *
   * @param self   The card on which the ability is being applied.
   * @param target The target card to which the ability is applied.
   */
  override def apply(self:Card, target: Card): Unit = {}
}
