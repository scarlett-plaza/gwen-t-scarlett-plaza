package cl.uchile.dcc
package gwent.board.sections

import gwent.board.sections.{ADistanciaSection, AsedioSection}
import gwent.cards.*
import gwent.player.Player

import java.util.Objects
import scala.collection.mutable.ListBuffer

/** A class representing the CuerpoACuerpo section of the board.
 *
 * @param section A listBuffer of the cards in the section, this cards can only be CuerpoACuerpo cards
 *
 * @constructor Creates a new CuerpoACuerpoSection with the given listBuffer of cards
 *
 * @example {{{
 *          val section = new CuerpoACuerpoSection(ListBuffer.empty[CuerpoACuerpoCard])
 *          }}}
 *
 * @see Board
 *
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
class CuerpoACuerpoSection(override val _section: ListBuffer[CuerpoACuerpoCard]) extends Section with Equals {
  def section: ListBuffer[CuerpoACuerpoCard] = _section
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[CuerpoACuerpoSection]
  }

  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val otherCuerpoACuerpoSection = obj.asInstanceOf[CuerpoACuerpoSection]
      (this eq otherCuerpoACuerpoSection) ||
        otherCuerpoACuerpoSection.section == section
    }
    else {
      false
    }
  }
  
  override def hashCode(): Int = {
    Objects.hash(_section)
  }
}