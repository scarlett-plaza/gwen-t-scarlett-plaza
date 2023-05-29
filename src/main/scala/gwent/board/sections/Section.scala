package cl.uchile.dcc
package gwent.board.sections

import gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection}

trait Section {
  val section: Any
  def addCard(that: Section): Section
  def addCardToADistancia(that: ADistanciaSection): Section
  def addCardToAsedio(that: AsedioSection): Section
  def addCardToCuerpoACuerpo(that: CuerpoACuerpoSection): Section
  def addCardToWeather(that: WeatherSection): Section
}
