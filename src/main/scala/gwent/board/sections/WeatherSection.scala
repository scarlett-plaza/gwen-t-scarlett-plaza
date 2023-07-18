package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.*
import gwent.player.Player

import java.util.Objects
import scala.collection.mutable.ListBuffer

/** A class representing the Weather section of the board.
 *
 * @param section A listBuffer of the cards in the section, this cards can only be Weather cards
 *
 * @constructor Creates a new WeatherSection with the given listBuffer of cards
 *
 * @example {{{
 *          val section = new WeatherSection(ListBuffer.empty[WeatherCard])
 *          }}}
 *
 * @see Board
 *
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
class WeatherSection(override val _section: ListBuffer[WeatherCard]) extends Section with Equals {
  def section: ListBuffer[WeatherCard] = _section
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[WeatherSection]
  }
  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val otherWeatherSection = obj.asInstanceOf[WeatherSection]
      (this eq otherWeatherSection) ||
        otherWeatherSection.section == section
    }
    else {
      false
    }
  }
  override def hashCode(): Int = {
    Objects.hash(_section)
  }
}
