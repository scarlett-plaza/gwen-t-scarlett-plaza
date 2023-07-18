package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.{Card, CuerpoACuerpoCard, WeatherCard}

class EscarchaMordiente() extends Habilidad{
  override def apply(self: Card, target: Card): Unit = {
    aplicar(self.asInstanceOf[WeatherCard], target.asInstanceOf[CuerpoACuerpoCard])
  }
  def aplicar(self: WeatherCard, target: CuerpoACuerpoCard): Unit = {
    if(self.active){
      target.currentPower = 1
    }
  }
}
