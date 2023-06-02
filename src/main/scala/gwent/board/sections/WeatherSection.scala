package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.*
import gwent.player.Player
import cl.uchile.dcc.gwent.InvalidOperationException

import scala.collection.mutable.ListBuffer

class WeatherSection(override val section: ListBuffer[WeatherCard]) extends Section {

  override def addCard(that: Card): Unit = {
    that.addCardToWeather(this)
  }
}
