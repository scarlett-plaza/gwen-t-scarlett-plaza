package cl.uchile.dcc
package gwent.cards

import gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection}

class AsedioCard (name: String, power: Int) extends AbstractUnitCard (name, power){
  def addCardToWeather(zone: WeatherSection): Unit= {???}

  def addCardToAsedio(zone: AsedioSection): Unit= {
    zone.section.append(this)
  }

  def addCardToCuerpoACuerpo(zone: CuerpoACuerpoSection): Unit= {???}

  def addCardToADistancia(zone: ADistanciaSection): Unit= {???}
}