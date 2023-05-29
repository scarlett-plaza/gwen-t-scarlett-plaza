package cl.uchile.dcc
package gwent.board.sections

import gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection}
import gwent.cards.*
import gwent.player.Player

import cl.uchile.dcc.gwent.board.exceptions.InvalidOperationException

import scala.collection.mutable.ListBuffer

class WeatherSection(override val section: ListBuffer[WeatherCard]) extends Section {

  override def addCard(that: Section): Section = {
    that.addCardToWeather(this)
  }

  override def addCardToWeather(that: WeatherSection): WeatherSection = {
    new WeatherSection(section.concat(that.section))
  }

  override def addCardToAsedio(that: AsedioSection): Nothing = throw new InvalidOperationException("You cant add a Asedio card in the Weather section")

  override def addCardToADistancia(that: ADistanciaSection): Nothing = throw new InvalidOperationException("You cant add a Distancia card in the Weather section")

  override def addCardToCuerpoACuerpo(that: CuerpoACuerpoSection): Nothing = throw new InvalidOperationException("You cant add a Cuerpo a cuerpo card in the Weather section")
}
