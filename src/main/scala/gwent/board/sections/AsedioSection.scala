package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.*
import gwent.player.Player

import java.util.Objects
import scala.collection.mutable.ListBuffer

/** A class representing the Asedio section of the board.
 *
 * @param section A listBuffer of the cards in the section, this cards can only be Asedio cards
 *
 * @constructor Creates a new AsedioSection with the given listBuffer of cards
 *
 * @example {{{
 *          val section = new AsedioSection(ListBuffer.empty[AsedioCard])
 *          }}}
 *
 * @see Board
 *
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 *         
 */
class AsedioSection(override val _section: ListBuffer[AsedioCard]) extends Section with Equals {
  /** Getter for section attribute
   *
   * @return ListBuffer[AsedioCard]
   */
  def section: ListBuffer[AsedioCard] = _section
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[AsedioSection]
  }

  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val otherAsedioSection = obj.asInstanceOf[AsedioSection]
      (this eq otherAsedioSection) ||
        otherAsedioSection.section == section
    }
    else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(_section)
  }
}