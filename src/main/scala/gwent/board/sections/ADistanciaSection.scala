package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.*
import gwent.player.Player

import java.util.Objects
import scala.collection.mutable.ListBuffer

/** A class representing the ADistancia section of the board.
 *
 * @param section A listBuffer of the cards in the section, this cards can only be ADistancia cards
 *                
 * @constructor Creates a new ADistanciaSection with the given listBuffer of cards
 *              
 * @example {{{
 *          val section = new ADistanciaSection(ListBuffer.empty[ADistanciaCard])
 *          }}}
 * 
 * @see Board
 * 
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
class ADistanciaSection(override val section: ListBuffer[ADistanciaCard]) extends Section with Equals {
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[ADistanciaSection]
  }

  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val otherADistanciaSection = obj.asInstanceOf[ADistanciaSection]
      (this eq otherADistanciaSection) ||
        otherADistanciaSection.section == section
    }
    else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(section)
  }
  /** Adds a card to the section
   *
   * @param that The card to be added
   * 
   * @return Unit
   */
  
  override def addCard(that: Card): Unit = {
    that.addCardToADistancia(this)
  }
}
  