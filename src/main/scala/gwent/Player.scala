package cl.uchile.dcc
package gwent
import java.util.Objects
import scala.collection.mutable.ListBuffer

//trait tPlayer {
////  def play_card():Unit
//  def draw_card():Unit
//}

/** A class player that plays with the cards
 *
 * @param _name It's the name of the player
 * @param board_sec It's the section where the player plays
 * @param _gems The amount of gems it has, everyone begins with 2 and loses one every time it loses, the game is over
 *              when it runs out of gems
 * @example
 * val player1 = New Player("Mario Hugo", 1)
 * player1.draw_card()
 *
 * @author Scarlett Plaza
 */
class Player(_name:String, board_sec: Int, private var _gems: Int = 2) extends PlayerFactory(_name, board_sec) with Equals {

  private var _deck = initial_deck()
  private var _hand_card = inital_handcard(deck)

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[Player]
  }

  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)){
      val otherPlayer = obj.asInstanceOf[Player]
      (this eq otherPlayer)||
      otherPlayer._name == _name &&
        otherPlayer.board_sec == board_sec &&
        otherPlayer._gems == _gems
    }
    else{false}
  }

  override def hashCode(): Int = {
    Objects.hash(_name, board_sec, _gems)
  }

  /** Getter of the deck
   *
   * @return deck
   */
  def deck: ListBuffer[Card] = {
    _deck
  }

  /**Getter of the cards on the hand
   *
   * @return hand_card
   */
  def hand_card: ListBuffer[Card] = {
    _hand_card
  }

  /** Takes a card of the deck and puts it in the hand cards
   * it doesn't return anything but it modifies the deck and hand card transferring the top card of the deck to the hand
   *
   * @example
   * println(s"Initial deck head name: ${_deck.head.name}, zone: ${_deck.head.name}, length: ${_deck.length}")
   * println(s"Initial hand card length: ${_hand_card.length}")
   * * _hand_card.foreach(card => println(s"Initial Name: ${card.name}, Zone: ${card.zone}"))
   * draw_card()
   * println(s"Posterior hand card length: ${_hand_card.length}")
   * println(s"Posterior name: ${_deck.head.name}, zone: ${_deck.head.name}, length: ${_deck.length}")
   * _hand_card.foreach(card => println(s"Posterior Name: ${card.name}, Zone: ${card.zone}"))
   */

  def draw_card(): Unit = {
    if (_deck.nonEmpty){
      _hand_card += _deck.head
      deck.remove(0)
    }
    else{
      println("No tienes mas cartas en el mazo")
    }
  }
  //  def play_card(): Unit = {
  //
  //  }
}
