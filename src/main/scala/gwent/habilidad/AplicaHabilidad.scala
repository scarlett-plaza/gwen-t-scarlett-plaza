package cl.uchile.dcc
package gwent.habilidad

import gwent.board.sections.Section
import gwent.cards.{Card}

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.player.Player

import java.util.Objects
/**
 * Class that represents an application of an ability to a card.
 *
 * @param name     The name of the applied ability.
 * @param habilidad The ability to be applied.
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
class AplicaHabilidad(val name: String, val habilidad: Habilidad) {
  /**
   * Applies the ability to the specified cards.
   *
   * @param self   The card whose ability is applied.
   * @param target The target card on which the ability is applied.
   */

  def apply(self: Card, target: Card): Unit = {
    habilidad.apply(self, target)
  }
}
