package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.*
import gwent.player.Player

import cl.uchile.dcc.gwent.board.exceptions.InvalidOperationException

import scala.collection.mutable.ListBuffer

class AsedioSection(override val section: ListBuffer[AsedioCard]) extends Section {

  override def addCard(that: Section): Section = {
    that.addCardToAsedio(this)
  }

  override def addCardToAsedio(that: AsedioSection): AsedioSection = {
    new AsedioSection(section.concat(that.section))
  }

  override def addCardToADistancia(that: ADistanciaSection): Nothing = throw new InvalidOperationException("You cant add a Distancia card in the Asedio section")

  override def addCardToCuerpoACuerpo(that: CuerpoACuerpoSection): Nothing = throw new InvalidOperationException("You cant add a Cuerpo a Cuerpo card in the Asedio section")

  override def addCardToWeather(that: WeatherSection): Nothing = throw new InvalidOperationException("You cant add a Weather card in the Asedio section")
}
