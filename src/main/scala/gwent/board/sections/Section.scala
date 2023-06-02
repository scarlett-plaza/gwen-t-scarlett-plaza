package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.Card

abstract class Section {
  val section: Any
  def addCard(that: Card): Unit
}
