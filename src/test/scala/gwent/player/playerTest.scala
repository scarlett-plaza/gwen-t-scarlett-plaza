package cl.uchile.dcc
package gwent.player

import gwent.cards.{ADistanciaCard, AsedioCard, Card, CuerpoACuerpoCard, WeatherCard}

import cl.uchile.dcc.gwent.board.Inicializador
import jdk.javadoc.internal.doclets.toolkit.util.DocFile.list
import munit.FunSuite

import scala.collection.mutable.ListBuffer

class PlayerTest extends FunSuite{

  val namesADistancia: List[String] = List("Elemento", "Chaucha", "Yo no fui", "Neumatex", "Maletin", "Jefe", "Yo soy", "Ro", "Duquesa")
  val cardsADistancia: List[ADistanciaCard] = List.tabulate(namesADistancia.length)(i => new ADistanciaCard(namesADistancia(i), 1))
  val namesAsedio: List[String] = List("Copi copi", "Mente en blanco", "Tepo tepo", "Palmerita", "Etcetera", "Rucia", "Guason", "Chu", "James Bond")
  val cardsAsedio: List[AsedioCard] = List.tabulate(namesAsedio.length)(i => new AsedioCard(namesAsedio(i), 1))
  val namesCuerpoACuerpo: List[String] = List("Adjetivo", "Coliforme", "Fierro malo", "Cortachurro", "Choapino", "Rata", "Cucky", "Neumatico", "Chamullo")
  val cardsCuerpoACuerpo: List[CuerpoACuerpoCard] = List.tabulate(namesCuerpoACuerpo.length)(i => new CuerpoACuerpoCard(namesCuerpoACuerpo(i), 1))
  val namesWeather: List[String] = List("Pescado", "Moneda", "Lili", "Calugoso", "Pelusa", "Amigo", "Calendario")
  val cardsWeather: List[WeatherCard] = List.tabulate(namesWeather.length)(i => new WeatherCard(namesWeather(i)))

  val cardsCards: List[Card] = List.concat(cardsADistancia, cardsAsedio, cardsCuerpoACuerpo, cardsWeather)

  val nombre1 = "Juan Carlos Bodoque"
  val section1 = 1
  val nombre2 = "Juanin Juan Harry"
  val section2 = 2
  val deckQuantity = 25
  val handQuantity = 10

  val iniciador = new Inicializador()

  val deck1: ListBuffer[Card] = iniciador.createDeck(cardsCards, deckQuantity)
  val hand1: ListBuffer[Card] = iniciador.createHand(deck1, handQuantity)
  val deck2: ListBuffer[Card] = iniciador.createDeck(cardsCards, deckQuantity)
  val hand2: ListBuffer[Card] = iniciador.createHand(deck2, handQuantity)

  val jugador1 = new Player(nombre1, 2, deck1, hand1, section1)
  val jugador2 = new Player(nombre1, 2, deck1, hand1, section1)
  val jugador3 = new Player(nombre1, 2, deck2, hand2, section1)
  val jugador4 = new Player(nombre2, 2, deck2, hand2, section2)

  test("Every Player has a initial handQuantity elements hand cards"){
    assertEquals(jugador1.hand.length, handQuantity)
  }

  test("Every Player has a X deck at the begining (X = deckQuantity-handQuantity)"){
    assertEquals(jugador1.deck.length, deckQuantity-handQuantity)
  }

  test("When you draw a card out of the deck there is one more card in the hand and one less in the deck"){
    val previousDeckLength = jugador1.deck.length
    val previousHandLength = jugador1.hand.length
    jugador1.drawCard()
    assertEquals(jugador1.deck.length, previousDeckLength-1)
    assertEquals(jugador1.hand.length, previousHandLength+1)
  }

  test("Dos jugadores son iguales Si su nombre y su sección del tablero es igual"){
    assert(jugador1.equals(jugador2))
    assert(jugador1.equals(jugador3))
    assert(!jugador1.equals(jugador4))
  }

  test("If there is no more cards in the deck and you try to draw one it does not let you") {
    val initialDeckLength = jugador1.deck.length
    val initialHandLength = jugador1.hand.length
    var cont = 0
    while (initialDeckLength - cont != 0) {
      jugador1.drawCard()
      cont += 1
    }
    jugador1.drawCard()
    assertEquals(jugador1.deck.length, 0)
    assertEquals(jugador1.hand.length, initialHandLength + initialDeckLength)
  }

  test("A player is not a card"){
    assert(!jugador1.equals(cardsADistancia(0)))
    assert(!jugador1.equals(cardsAsedio(0)))
    assert(!jugador1.equals(cardsCuerpoACuerpo(0)))
    assert(!jugador1.equals(cardsWeather(0)))
  }

  test("A player loses if there is no more gems"){
    val initialGem = jugador1.gem
    var cont = 0
    while (initialGem- cont != 0) {
      jugador1.loseGem()
      cont += 1
      assert(jugador1.gem == initialGem-cont)
    }
    jugador1.loseGem()
    assert(jugador1.gem == 0)
  }

  test("Al revolver un mazo, se mantienen las mismas cartas"){
    val deck = jugador1.deck
    jugador1.shuffleDeck()
    val shuffledDeck = jugador1.deck
    assert(deck.toSet == shuffledDeck.toSet)
  }
  test("Comparar hashCode"){
    assert(jugador1.hashCode.equals(jugador2.hashCode))
  }
  test("No se puede hacer la mano del jugador si requiere más cartas que las que tiene el deck"){
    val deck3: ListBuffer[Card] = iniciador.createDeck(cardsCards, 10)
    val hand3: ListBuffer[Card] = iniciador.createHand(deck3, 12)
    assertEquals(hand3.length, 0)
    assert(deck3.length == 10)
  }
}
