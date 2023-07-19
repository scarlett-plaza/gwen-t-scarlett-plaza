package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.{Card, CuerpoACuerpoCard, WeatherCard}

/**
 * EscarchaMordiente represents an ability that reduces the power of a CuerpoACuerpoCard to 1.
 * It extends the Habilidad class.
 *
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
class EscarchaMordiente() extends Habilidad{
  /**
   * Applies the EscarchaMordiente ability to a target card.
   *
   * @param self   The card on which the ability is being applied.
   * @param target The target card to apply the ability to.
   */
  override def apply(self: Card, target: Card): Unit = {
    aplicar(self.asInstanceOf[WeatherCard], target.asInstanceOf[CuerpoACuerpoCard])
  }

  /**
   * Applies the EscarchaMordiente ability to a target CuerpoACuerpoCard
   * if the WeatherCard associated with the ability is active.
   *
   * @param self   The WeatherCard associated with the ability.
   * @param target The CuerpoACuerpoCard to apply the ability to.
   */
  def aplicar(self: WeatherCard, target: CuerpoACuerpoCard): Unit = {
    if(self.active){
      target.currentPower = 1
    }
  }
}
