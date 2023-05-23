package cl.uchile.dcc
package gwent.tablero

import scala.util.Random
import gwent.cards.{ADistanciaCard, AsedioCard, CuerpoACuerpoCard, WeatherCard}

class Inicializador {
  def createDeck(availableCards: ListBuffer[Card], quantity: Int): ListBuffer[Card]={
    val random = new Random()
    val randomDeck = ListBuffer.fill(quantity)(availableCards(random.nextInt(availableCards.length)))
    return randomDeck
  }
  def createHand(deck: ListBuffer[Card], quantity: Int): ListBuffer[Card]={
    val handCard = deck.take(quantity)
    var i = 0
    while (i < quantity) {
      deck.remove(0)
      i += 1
    }
    handCard
  }
}
