package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.*
import gwent.player.Player
import cl.uchile.dcc.gwent.InvalidOperationException

import scala.collection.mutable.ListBuffer

class ADistanciaSection(override val section: ListBuffer[ADistanciaCard]) extends Section {

  override def addCard(that: Card): Unit = {
    that.addCardToADistancia(this)
  }
}
  