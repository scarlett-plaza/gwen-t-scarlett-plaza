package cl.uchile.dcc
package gwent.board

import gwent.cards.Card

import scala.collection.mutable.ListBuffer
import scala.util.Random

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
