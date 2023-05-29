package cl.uchile.dcc
package gwent.board
import gwent.cards.{ADistanciaCard, AsedioCard, Card, CuerpoACuerpoCard, WeatherCard}

import cl.uchile.dcc.gwent.player.Player

import scala.collection.mutable.ListBuffer

class AsedioSection(override val section: AsedioCard, player: Player) extends Section {

  val sectionAsedio: ListBuffer[AsedioCard] = ListBuffer.empty[AsedioCard]

  override def addCard(that: Section): Unit = {
    that.addCardTo(this.section)
  }

  override def addCardTo(that: ADistanciaCard): Unit = {
    ???
  }

  override def addCardTo(that: AsedioCard): Unit = {
    sectionAsedio.append(that)
  }

  override def addCardTo(that: CuerpoACuerpoCard): Unit = {
    ???
  }

  override def addCardTo(that: WeatherCard): Unit = ???
}
