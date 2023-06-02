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
  def createDeck(availableCards: List[Card], quantity: Int): ListBuffer[Card]={
    val random = new Random()
    val randomDeck = ListBuffer.fill(quantity)(availableCards(random.nextInt(availableCards.length)))
    randomDeck
  }
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
