package cl.uchile.dcc
package gwent.board.sections

import gwent.board.sections.{ADistanciaSection, AsedioSection}
import gwent.cards.*
import gwent.player.Player
import cl.uchile.dcc.gwent.InvalidOperationException

import scala.collection.mutable.ListBuffer

class CuerpoACuerpoSection(override val section: ListBuffer[CuerpoACuerpoCard]) extends Section {

  override def addCard(that: Card): Unit= {
    that.addCardToCuerpoACuerpo(this)
  }
}