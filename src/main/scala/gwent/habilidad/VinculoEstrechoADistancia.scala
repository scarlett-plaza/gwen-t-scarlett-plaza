package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.{ADistanciaCard, Card}
/**
 * VinculoEstrechoADistancia represents the ability of a card of doubling the current power of both the self and target ADistanciaCard.
 * It extends the Habilidad class.
 * This ability doubles the current power of both the self and target ADistanciaCard.
 *
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
class VinculoEstrechoADistancia() extends Habilidad {
  /**
   * Applies the ability to the self and target Card.
   * @param self
   * @param target
   */
  override def apply(self: Card, target: Card): Unit = {
    aplicar(self.asInstanceOf[ADistanciaCard], target.asInstanceOf[ADistanciaCard])
  }

  /**
   * Applies the ability to the self and target ADistanciaCard.
   * @param self
   * @param target
   */
  def aplicar(self: ADistanciaCard, target: ADistanciaCard): Unit = {
    self.currentPower = 2* self.currentPower
    target.currentPower = 2* target.currentPower
  }
}
