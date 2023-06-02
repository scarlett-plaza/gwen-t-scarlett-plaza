package cl.uchile.dcc
package gwent.player

import gwent.cards.Card

import java.util.Objects
import scala.collection.mutable.ListBuffer

/** A class representing a player in the game Gwent
 *
 * @param name String of the name of the player
 * @param gem Int of the gem of the player
 * @param deck ListBuffer of the cards in the deck of the player
 * @param hand ListBuffer of the cards in the hand of the player
 * @param boardSec Int of the board section of the player
 *
 * @constructor Creates a new Player with the given parameters
 *
 * @example {{{
 *          val player1 = New Player("Mario Hugo", 2, ListBuffer[Card], ListBuffer[Card], 1)
 *          }}}
 *
 * @see Inicializador
 *
 * @author Scarlett Plaza
 * @since 1.5
 * @version 2.0
 */

class Player(val name: String, var _gem: Int, var _deck: ListBuffer[Card], var _hand: ListBuffer[Card],val boardSec: Int) extends Equals {
  def deck: ListBuffer[Card] = _deck
  def hand: ListBuffer[Card] = _hand
  def gem: Int = _gem

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[Player]
  }

  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)){
      val otherPlayer = obj.asInstanceOf[Player]
      (this eq otherPlayer)||
        otherPlayer.name == name &&
          otherPlayer.boardSec == boardSec
    }
    else{false}
  }

  override def hashCode(): Int = {
    Objects.hash(name, boardSec)
  }

  def shuffleDeck(): Unit = {
    _deck = scala.util.Random.shuffle(_deck)
  }

  def loseGem(): Unit ={
    if (_gem<=0) {
      println("Has perdido")
    }
    else {
      _gem-=1
    }
  }

  def drawCard(): Unit = {
    if (_deck.nonEmpty) {
      _hand += _deck.head
      deck.remove(0)
    }
    else {
      println("No tienes mas cartas en el mazo")
    }
  }
}
