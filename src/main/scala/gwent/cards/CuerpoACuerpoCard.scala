package cl.uchile.dcc
package gwent.cards

import gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection}

class CuerpoACuerpoCard (name: String, power: Int) extends AbstractUnitCard(name, power) {
  def addCardToWeather(zone: WeatherSection): Unit = {
    ???
  }

  def addCardToAsedio(zone: AsedioSection): Unit = {
    ???
  }
  
  def addCardToCuerpoACuerpo(zone: CuerpoACuerpoSection): Unit = {
    zone.section.append(this)
  }

  def addCardToADistancia(zone: ADistanciaSection): Unit = {
    ???
  }
}
