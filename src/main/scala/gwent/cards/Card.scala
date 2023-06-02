package cl.uchile.dcc
package gwent.cards

import gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection}

trait Card {
  var hola:Int
  val name: String
  def addCardToWeather(zone: WeatherSection): Unit
  def addCardToAsedio(zone: AsedioSection): Unit
  def addCardToCuerpoACuerpo(zone: CuerpoACuerpoSection): Unit
  def addCardToADistancia(zone: ADistanciaSection): Unit
}
