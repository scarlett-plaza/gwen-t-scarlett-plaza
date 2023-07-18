package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.{ADistanciaCard, Card, WeatherCard}

class NieblaImpenetrable() extends Habilidad{
  override def apply(self: Card, target: Card): Unit = {
    aplicar(self.asInstanceOf[WeatherCard], target.asInstanceOf[ADistanciaCard])
  }

  def aplicar(self: WeatherCard, target: ADistanciaCard): Unit = {
    if(self.active){
      target.currentPower = 1
    }
  }
}
