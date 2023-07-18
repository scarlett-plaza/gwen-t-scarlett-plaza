package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.{AsedioCard, Card, WeatherCard}

class LluviaTorrencial() extends Habilidad {
  override def apply(self: Card, target: Card): Unit = {
    aplicar(self.asInstanceOf[WeatherCard], target.asInstanceOf[AsedioCard])
  }

  def aplicar(self: WeatherCard, target: AsedioCard): Unit = {
    if (self.active){
      target.currentPower = 1
    }
  }
}
