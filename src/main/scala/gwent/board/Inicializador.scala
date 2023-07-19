package cl.uchile.dcc
package gwent.board

import gwent.cards.Card

import scala.collection.mutable.ListBuffer
import scala.util.Random

/** A class in charge of initializing each player's deck and hand
 *
 * @example {{{
 *          val inicializador = new Inicializador
 *          val deck = inicializador.createDeck(availableCards, 10)
 *          val hand = inicializador.createHand(deck, 3)
 *          }}}
 *
 * @see Board
 *
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
class Inicializador {
  /**
   * Creates a deck of cards with the specified quantity by randomly selecting cards from the available cards.
   *
   * @param availableCards A list of available cards to choose from.
   * @param quantity       The number of cards to include in the deck.
   * @return A list buffer containing the randomly created deck of cards.
   */
  def createDeck(availableCards: List[Card], quantity: Int): ListBuffer[Card]={
    val random = new Random()
    val randomDeck = ListBuffer.fill(quantity)(availableCards(random.nextInt(availableCards.length)))
    randomDeck
  }

  /**
   * Creates a hand of cards by taking the specified quantity of cards from the deck.
   * The cards are taken from the top of the deck and in case there is not enough cards in the deck, an empty list buffer is returned and it prints the message "No tienes suficientes cartas".
   * 
   * @param deck     The list buffer representing the deck of cards.
   * @param quantity The number of cards to include in the hand.
   * @return A list buffer containing the cards in the hand.
   */
  def createHand(deck: ListBuffer[Card], quantity: Int): ListBuffer[Card]={
    if(deck.length<quantity){
      println("No tienes suficientes cartas")
      ListBuffer.empty[Card]
    }
    else {
      val handCard = deck.take(quantity)
      var count = 0
      while (count < quantity){
        deck.remove(0)
        count+=1
      }
      return handCard
    }
  }
}
