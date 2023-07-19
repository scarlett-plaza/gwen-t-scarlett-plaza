package cl.uchile.dcc
package gwent.player

import gwent.board.Inicializador

import cl.uchile.dcc.gwent.cards.{Card, CardFactory}

import scala.collection.mutable.ListBuffer

/**
 * PlayerFactory is responsible for creating instances of the Player class.
 * It implements the PFactory trait.
 *
 * @note PlayerFactory assumes the existence of the Inicializador and CardFactory classes.
 * @param name          The name of the player.
 * @param deckQuantity  The quantity of cards in the deck.
 * @param handQuantity  The quantity of cards in the initial hand.
 * @param gems          The initial amount of gems.
 * @return A new instance of the Player class with the specified parameters.
 * @see Player
 * @see Inicializador
 * @see CardFactory
 * @see PFactory
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */

class PlayerFactory extends PFactory{
  override def apply(name: String,deckQuantity: Int, handQuantity: Int, gems: Int): Player = {
    val inicializador = new Inicializador()
    val cardFactory = new CardFactory()
    val cards: List[Card] = cardFactory.cardsCards
    val deck: ListBuffer[Card] = inicializador.createDeck(cards, deckQuantity)
    val hand: ListBuffer[Card] = inicializador.createHand(deck, handQuantity)
    new Player(name,gems, deck, hand)
  }
}
