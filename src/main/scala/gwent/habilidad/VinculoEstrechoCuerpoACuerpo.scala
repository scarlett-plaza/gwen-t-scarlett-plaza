package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.{CuerpoACuerpoCard, Card}
/**
 * VinculoEstrechoCuerpoACuerpo represents the ability of a CuerpoACuerpoCard that doubles the current power of both the self and target CuerpoACuerpoCard.
 * It extends the Habilidad class.
 * This ability doubles the current power of both the self and target ADistanciaCard.
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */

class VinculoEstrechoCuerpoACuerpo() extends Habilidad {
  /**
   * Applies the ability to the self and target Card
   *
   * @param self   the CuerpoACuerpoCard that has the ability
   * @param target the CuerpoACuerpoCard that will be affected by the ability
   */
  override def apply(self: Card, target: Card): Unit = {
    aplicar(self.asInstanceOf[CuerpoACuerpoCard], target.asInstanceOf[CuerpoACuerpoCard])
  }

  /**
   * Applies the ability to the self and target CuerpoACuerpoCard
   *
   * @param self   the CuerpoACuerpoCard that has the ability
   * @param target the CuerpoACuerpoCard that will be affected by the ability
   */
  def aplicar(self: CuerpoACuerpoCard, target: CuerpoACuerpoCard): Unit = {
    self.currentPower = 2* self.currentPower
    target.currentPower = 2* target.currentPower
  }
}
