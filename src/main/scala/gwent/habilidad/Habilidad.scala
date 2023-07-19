package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.Card

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.board.sections.Section
import cl.uchile.dcc.gwent.player.Player

trait Habilidad {
  def apply(self: Card, target: Card):Unit
}
