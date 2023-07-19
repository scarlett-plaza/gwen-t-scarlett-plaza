package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.{ADistanciaCard, Card, WeatherCard}
/**
 * NieblaImpenetrable represents the ability of a weather card that reduces the power of a ADistancia card to 1.
 * It extends the Habilidad class.
 *
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
class NieblaImpenetrable() extends Habilidad{
  /**
   * Applies the NieblaImpenetrable ability to a target card.
   *
   * @param self   The card on which the ability is being applied.
   * @param target The target card to apply the ability to.
   */
  override def apply(self: Card, target: Card): Unit = {
    aplicar(self.asInstanceOf[WeatherCard], target.asInstanceOf[ADistanciaCard])
  }

  /**
   * Applies the NieblaImpenetrable ability to a target ADistanciaCard
   * if the WeatherCard associated with the ability is active.
   *
   * @param self   The WeatherCard associated with the ability.
   * @param target The ADistanciaCard to apply the ability to.
   */
  def aplicar(self: WeatherCard, target: ADistanciaCard): Unit = {
    if(self.active){
      target.currentPower = 1
    }
  }
}
