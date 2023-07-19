package cl.uchile.dcc
package gwent.cards

import gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection}

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.habilidad.AplicaHabilidad
import cl.uchile.dcc.gwent.player.Player
/** A class representing the CuerpoACuerpo cards in the game GWENT.
 *
 * @param name String of the name of the card
 * @param power Int of the power of the card
 *
 * @constructor Creates a new CuerpoACuerpoCard with the given name and power
 *
 * @example {{{
 *          val cuerpoACuerpoCard = new CuerpoACuerpoCard("Adjetivo", 1)
 *          }}}
 *
 * @see AbstractUnitCard
 *
 * @author Scarlett Plaza
 * @since 1.5
 * @version 2.0
 */
class CuerpoACuerpoCard (name: String, power: Int, habilidad: List[AplicaHabilidad]) extends AbstractUnitCard(name, power, habilidad) {
  /**
   * Adds the CuerpoACuerpo to the corresponding section of the player's board, works by using double dispatch
   *
   * @param player The player to whom the CuerpoACuerpo belongs.
   * @param board  The game board where the CuerpoACuerpo will be added.
   */
  override def addToSection(player: Player, board: Board): Unit = {
    board.addToCuerpoACuerpoSection(this, player)
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
