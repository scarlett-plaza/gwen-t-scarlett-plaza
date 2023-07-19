package cl.uchile.dcc
package gwent.cards

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, Section, WeatherSection}
import cl.uchile.dcc.gwent.habilidad.AplicaHabilidad
import cl.uchile.dcc.gwent.player.Player

import java.util.Objects

/** A class representing the Weather cards in the game GWENT.
 *
 * @param name String of the name of the card
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

class WeatherCard(override val name: String, override val habilidad: List[AplicaHabilidad]) extends Card with Equals {
  var active: Boolean = true
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
  /**
   * Adds the WeatherCard to the corresponding section of the player's board, works by using double dispatch
   *
   * @param player The player to whom the WeatherCard belongs.
   * @param board  The game board where the WeatherCard will be added.
   */
  override def addToSection(player: Player, board: Board): Unit = {
    board.addToWeatherSection(this, player)
  }
  /**
   * Applies the ability at the specified index to a target card works using Template pattern and Null Object pattern
   *
   * @param index  The index of the ability to be applied.
   * @param target The card on which the ability will be applied.
   */
  def aplicaHabilidad(index: Int, target: Card): Unit = {
    if (index >= 0 && index < habilidad.length) {
      val habilidades = habilidad(index)
      habilidades(this.asInstanceOf[Card], target)
    }
  }
}
