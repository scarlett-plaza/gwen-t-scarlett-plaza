package cl.uchile.dcc
package gwent.player

import gwent.cards.Card

import java.util.Objects
import scala.collection.mutable.ListBuffer

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
