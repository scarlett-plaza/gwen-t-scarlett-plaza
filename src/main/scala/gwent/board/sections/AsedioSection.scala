package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.*
import gwent.player.Player
import cl.uchile.dcc.gwent.InvalidOperationException

import scala.collection.mutable.ListBuffer

class AsedioSection(override val section: ListBuffer[AsedioCard]) extends Section {

  override def addCard(that: Card): Unit = {
    that.addCardToAsedio(this)
  }
}