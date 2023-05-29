package cl.uchile.dcc
package gwent.board
import gwent.cards.{ADistanciaCard, AsedioCard, Card, CuerpoACuerpoCard, WeatherCard}

import cl.uchile.dcc.gwent.player.Player

import scala.collection.mutable.ListBuffer

class ADistanciaSection(override val section: ADistanciaCard, val player: Player) extends Section {

  val sectionADistancia: ListBuffer[ADistanciaCard] = ListBuffer.empty[ADistanciaCard]

  override def addCard(that: Section): Unit = {
    that.addCardTo(this.section)
  }

  override def addCardTo(that: ADistanciaCard): Unit = {
    sectionADistancia.append(that)
  }
  
  override def addCardTo(that: AsedioCard): Unit = ???
  override def addCardTo(that: CuerpoACuerpoCard): Unit = ???

  override def addCardTo(that: WeatherCard): Unit = ???
}
