package cl.uchile.dcc
package gwent.cards


import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection}
import cl.uchile.dcc.gwent.habilidad.AplicaHabilidad
import cl.uchile.dcc.gwent.player.Player

import java.util.Objects
/** An abstract class representing unit cards in the game
 *
 * @param name String with the name of the card
 * @param power Int with the power of the card
 *
 * @see ADistanciaCard, AsedioCard, CuerpoACuerpoCard
 *
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
abstract class AbstractUnitCard(val name: String, private val power: Int, val habilidad: List[AplicaHabilidad]) extends Card with Equals {

  var currentPower: Int = power

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[AbstractUnitCard]
  }

  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val otherCard = obj.asInstanceOf[AbstractUnitCard]
      (this eq otherCard) ||
        otherCard.name == name &&
          otherCard.currentPower == currentPower &&
          otherCard.power == power &&
          otherCard.habilidad == habilidad
    }
    else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(name, power, habilidad)
  }
}
