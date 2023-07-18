package cl.uchile.dcc
package gwent.controlador

import gwent.cards.{ADistanciaCard, AsedioCard, Card, CuerpoACuerpoCard, WeatherCard}

class ComienzaPartida extends State {
  override def iniciaJuego() = this.changeState(new ComienzaRonda())
}
