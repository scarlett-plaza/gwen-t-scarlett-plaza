package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.{AsedioCard, Card}
/**
 * VinculoEstrechoAsedio represents the ability of the AsedioCard class of doubling the current power of both the self and target ASedioCard
 * It extends the Habilidad class.
 * This ability doubles the current power of both the self and target AsedioCard.
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
class VinculoEstrechoAsedio() extends Habilidad {
  /**
   * Applies the ability to the self and target Card
   * @param self the AsedioCard that has the ability
   * @param target the AsedioCard that will be affected by the ability
   */
  override def apply(self: Card, target: Card): Unit = {
    aplicar(self.asInstanceOf[AsedioCard], target.asInstanceOf[AsedioCard])
  }
  /**
   * Applies the ability to the self and target AsedioCard
   * @param self the AsedioCard that has the ability
   * @param target the AsedioCard that will be affected by the ability
   */
  def aplicar(self: AsedioCard, target: AsedioCard): Unit = {
    self.currentPower = 2* self.currentPower
    target.currentPower = 2* target.currentPower
  }
}
