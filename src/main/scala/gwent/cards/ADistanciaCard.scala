package cl.uchile.dcc
package gwent.cards

import gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection}

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.habilidad.AplicaHabilidad
import cl.uchile.dcc.gwent.player.Player

import java.lang.annotation.Target
/** A class representing the aDistancia cards in the game GWENT.
 *
 * @param name String of the name of the card
 * @param power Int of the power of the card
 *
 * @constructor Creates a new ADistanciaCard with the given name and power
 *
 * @example {{{
 *          val aDistanciaCard = new ADistanciaCard("Elemento", 1)
 *          }}}
 *
 * @see AbstractUnitCard
 *
 * @author Scarlett Plaza
 * @since 1.5
 * @version 2.0
 */
class ADistanciaCard (name: String, power: Int, habilidad: List[AplicaHabilidad]) extends AbstractUnitCard (name, power, habilidad){
  override def addToSection(player: Player, board: Board): Unit = {
    board.addToADistanciaSection(this, player)
  }
  def aplicaHabilidad(index:Int, target: Card): Unit = {
    if (index>=0 && index<habilidad.length){
      val habilidades = habilidad(index)
      habilidades(this.asInstanceOf[Card], target)
    }
  }
}

