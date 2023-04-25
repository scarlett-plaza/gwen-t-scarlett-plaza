package cl.uchile.dcc
package gwent

import scala.collection.mutable.ListBuffer
import scala.util.Random

//trait tPlayerFactory {
//  def initial_deck():ListBuffer[Card]
//  def initial_hand(deck: ListBuffer[Card]): ListBuffer[Card]
//}

/** Abstract class that creates a random initial deck and hand card for a player but the functions are not used here
 *
 * @param _name name of the player
 * @param board_sec section of the player
 *
 */
abstract class PlayerFactory(protected val _name:String, protected val board_sec: Int) extends DeckFactory {

  /** Makes an initial deck for a player
   *
   * @return ListBuffer[Card] that represents a deck of cards
   */
  def initial_deck():ListBuffer[Card] = {
    var adeck = random_deck()
    adeck
  }

  /** Takes the first 10 cards of the deck and construct a hand of cards
   *
   * @param deck the deck from where you take the cards
   * @return ListBuffer[Card] that representas the hand cards
   */
  def inital_handcard(deck: ListBuffer[Card]): ListBuffer[Card] = {
    val ahand_card = deck.take(10)
    var i = 0
    while (i < 10) {
      deck.remove(0)
      i+=1
    }
    ahand_card
  }
}
