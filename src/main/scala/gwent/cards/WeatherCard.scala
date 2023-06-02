package cl.uchile.dcc
package gwent.cards

import cl.uchile.dcc.gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, Section, WeatherSection}

import java.util.Objects

/** A class representing the Weather cards in the game GWENT.
 *
 * @param name String of the name of the card
 * @param power Int of the power of the card
 *
 * @constructor Creates a new Weather with the given name
 *
 * @example {{{
 *          val Weather = new Weather("Pescado")
 *          }}}
 *
 * @see Card
 *
 * @author Scarlett Plaza
 * @since 1.5
 * @version 2.0
 */

class WeatherCard(override val name: String) extends Card with Equals {
  var hola: Int = -1
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[Card]
  }
  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val otherCard = obj.asInstanceOf[Card]
      (this eq otherCard) ||
        otherCard.name == name
    }
    else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(name)
  }

  def addCardToADistancia(zone: ADistanciaSection): Unit = {
    hola = 0
  }

  def addCardToAsedio(zone: AsedioSection): Unit = {
    hola = 1
  }

  def addCardToCuerpoACuerpo(zone: CuerpoACuerpoSection): Unit = {
    hola = 2
  }
  
  def addCardToWeather(zone: WeatherSection): Unit = {
    zone.section.append(this)
  }
}
