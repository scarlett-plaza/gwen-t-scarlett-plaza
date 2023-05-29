package cl.uchile.dcc
package gwent.board
import gwent.cards.{ADistanciaCard, AsedioCard, Card, CuerpoACuerpoCard, WeatherCard}

import cl.uchile.dcc.gwent.player.Player

import scala.collection.mutable.ListBuffer

class CuerpoACuerpoSection(override val section: CuerpoACuerpoCard, player: Player) extends Section {

  val sectionCuerpoACuerpo: ListBuffer[CuerpoACuerpoCard] = ListBuffer.empty[CuerpoACuerpoCard]

  override def addCard(that: Section): Unit = {
    that.addCardTo(this.section)
  }

  override def addCardTo(that: ADistanciaCard): Unit = {
    ???
  }

  override def addCardTo(that: AsedioCard): Unit = {
    ???
  }

  override def addCardTo(that: CuerpoACuerpoCard): Unit = {
    sectionCuerpoACuerpo.append(that)
  }

  override def addCardTo(that: WeatherCard): Unit = ???
}