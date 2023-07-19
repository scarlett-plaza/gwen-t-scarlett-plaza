package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.{Card, WeatherCard}

class ClimaDespejado() extends Habilidad {
  /**
   * Applies the ability to the specified cards.
   *
   * @param self   The card whose ability is applied.
   * @param target The target card on which the ability is applied.
   */
  override def apply(self: Card, target: Card): Unit = {
    aplicar(self.asInstanceOf[WeatherCard], target.asInstanceOf[WeatherCard])
  }

  def aplicar(self: WeatherCard, target: WeatherCard): Unit = {
    target.active = false
  }
}
