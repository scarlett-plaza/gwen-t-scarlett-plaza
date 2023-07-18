package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.{Card, WeatherCard}

class ClimaDespejado() extends Habilidad {
  override def apply(self: Card, target: Card): Unit = {
    aplicar(self.asInstanceOf[WeatherCard], target.asInstanceOf[WeatherCard])
  }

  def aplicar(self: WeatherCard, target: WeatherCard): Unit = {
    target.active = false
  }
}
