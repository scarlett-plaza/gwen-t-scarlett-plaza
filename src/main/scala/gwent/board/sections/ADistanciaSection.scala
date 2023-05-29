package cl.uchile.dcc
package gwent.board.sections

import gwent.board.exceptions.InvalidOperationException
import gwent.cards.*
import gwent.player.Player

import scala.collection.mutable.ListBuffer

class ADistanciaSection(override val section: ListBuffer[ADistanciaCard]) extends Section {

  override def addCard(that: Section): Section = {
    that.addCardToADistancia(this)
  }

  override def addCardToADistancia(that: ADistanciaSection): ADistanciaSection = {
    new ADistanciaSection(section.concat(that.section))
  }
  
  override def addCardToAsedio(that: AsedioSection): Nothing = throw new InvalidOperationException("You cant add a Asedio card in the a Distancia section")
  override def addCardToCuerpoACuerpo(that: CuerpoACuerpoSection): Nothing = throw new InvalidOperationException("You cant add a Cuerpo a Cuerpo card in the a Distancia section")

  override def addCardToWeather(that: WeatherSection): Nothing = throw new InvalidOperationException("You cant add a Weather card in the A Distancia section")
}
