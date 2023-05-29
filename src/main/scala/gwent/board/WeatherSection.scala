package cl.uchile.dcc
package gwent.board
import gwent.cards.{ADistanciaCard, AsedioCard, Card, CuerpoACuerpoCard, WeatherCard}

import cl.uchile.dcc.gwent.player.Player

import scala.collection.mutable.ListBuffer

class WeatherSection(override val section: WeatherCard) extends Section {

  val sectionWeather: ListBuffer[WeatherCard] = ListBuffer.empty[WeatherCard]

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
    ???
  }

  override def addCardTo(that: WeatherCard): Unit = {
    sectionWeather.append(that)
  }
}