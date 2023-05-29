package cl.uchile.dcc
package gwent.board.sections

import gwent.board.sections.{ADistanciaSection, AsedioSection}
import gwent.cards.*
import gwent.player.Player

import cl.uchile.dcc.gwent.board.exceptions.InvalidOperationException

import scala.collection.mutable.ListBuffer

class CuerpoACuerpoSection(override val section: ListBuffer[CuerpoACuerpoCard]) extends Section {

  override def addCard(that: Section): Section = {
    that.addCardToCuerpoACuerpo(this)
  }

  override def addCardToCuerpoACuerpo(that: CuerpoACuerpoSection): CuerpoACuerpoSection = {
    new CuerpoACuerpoSection(section.concat(that.section))
  }

  override def addCardToAsedio(that: AsedioSection): Nothing = throw new InvalidOperationException("You cant add a Asedio card in the Cuerpo a Cuerpo section")
  override def addCardToADistancia(that: ADistanciaSection): Nothing = throw new InvalidOperationException("You cant add a Distancia card in the Cuerpo a Cuerpo section")

  override def addCardToWeather(that: WeatherSection): Nothing = throw new InvalidOperationException("You cant add a Weather card in the Cuerpo a Cuerpo section")
}
