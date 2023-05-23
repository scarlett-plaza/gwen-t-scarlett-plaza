package cl.uchile.dcc
package gwent.player

<<<<<<< Updated upstream
import gwent.Card

import munit.FunSuite


val unitcards_available = Map("Copi copi" -> "Asedio", "Elemento" -> "Cuerpo a cuerpo", "Adjetivo" -> "Combate a distancia",
  "Mente en blanco" -> "Asedio", "Chaucha" -> "Cuerpo a cuerpo",
  "Coliforme" -> "Combate a distancia", "Tepo tepo" -> "Asedio", "Yo no fui" -> "Cuerpo a cuerpo",
  "Fierro malo" -> "Combate a distancia", "Palmerita" -> "Asedio", "Neumatex" -> "Cuerpo a cuerpo",
  "Cortachurro" -> "Combate a distancia", "Etcetera" -> "Asedio", "Maletin" -> "Cuerpo a cuerpo",
  "Choapino" -> "Combate a distancia", "Rucia" -> "Asedio", "Jefe" -> "Cuerpo a cuerpo",
  "Rata" -> "Combate a distancia")
val avilityunitcards_available = Map("Guason" -> "Asedio", "Yo soy" -> "Cuerpo a cuerpo",
  "Cucky" -> "Combate a distancia", "Chu" -> "Asedio", "Ro" -> "Cuerpo a cuerpo",
  "Neumatico" -> "Combate a distancia", "James Bond" -> "Asedio",
  "Senhor" -> "Cuerpo a cuerpo", "Chamullo" -> "Combate a distancia",
  "Duquesa" -> "Asedio")
val wheathercards_available = Map("Pescado" -> "Asedio", "Moneda" -> "Cuerpo a cuerpo", "Lili" -> "Cuerpo a cuerpo",
  "Calugoso" -> "Asedio", "Pelusa" -> "Cuerpo a cuerpo", "Amigo" -> "Cuerpo a cuerpo",
  "Calendario" -> "Asedio")
val complete_unitcard = unitcards_available ++ avilityunitcards_available
val cards_available = complete_unitcard ++ wheathercards_available

class PlayerTest extends FunSuite{
  val nombre1 = "Juan Carlos Bodoque"
  val seccion1 = 1
  val nombre2 = "Juanin"
  val seccion2 = 2
  val jugador1 = new Player(nombre1, seccion1)
  val jugador2 = new Player(nombre1, seccion1)
  val jugador3 = new Player(nombre2, seccion2)

  test("Every Player has a initial 10 elements hand cards"){
    assertEquals(jugador1.hand_card.length, 10)
  }

  test("Every Player has a 15 deck at the begining (the 25 initial - 10 of the hand cards)"){
    assertEquals(jugador1.deck.length, 15)
  }

  test("When you draw a card out of the deck there is one more card in the hand and one less in the deck"){
    val previous_deck_length = jugador1.deck.length
    val previous_hand_length = jugador1.hand_card.length
    jugador1.drawCard()
    assertEquals(jugador1.deck.length, previous_deck_length-1)
    assertEquals(jugador1.hand_card.length, previous_hand_length+1)
=======
import gwent.cards.{ADistanciaCard, AsedioCard, Card, CuerpoACuerpoCard, WeatherCard}
import gwent.Card

import jdk.javadoc.internal.doclets.toolkit.util.DocFile.list
import munit.FunSuite

import scala.collection.mutable.ListBuffer


val namesADistancia: List[ADistanciaCard] = list("Elemento", "Chaucha", "Yo no fui", "Neumatex", "Maletin", "Jefe", "Yo soy", "Ro", "Duquesa")
val namesAsedio: List[AsedioCard] = list("Copi copi", "Mente en blanco", "Tepo tepo", "Palmerita", "Etcetera", "Rucia", "Guason", "Chu", "James Bond")
val namesCuerpoACuerpo: List[CuerpoACuerpoCard] = list("Adjetivo", "Coliforme", "Fierro malo", "Cortachurro", "Choapino", "Rata", "Cucky", "Neumatico", "Chamullo")
val namesWeather: List[WeatherCard] = list("Pescado", "Moneda", "Lili", "Calugoso", "Pelusa", "Amigo", "Calendario")

val namesCards: List[Card] = List.concat(namesADistancia, namesAsedio, namesCuerpoACuerpo, namesWeather)

class PlayerTest extends FunSuite{
  val nombre1 = "Juan Carlos Bodoque"
  val section1 = 1
  val nombre2 = "Juanin Juan Harry"
  val section2 = 2
  val deckQuantity = 25
  val handQuantity = 10
  val deck1: ListBuffer[Card] = Inicializador.createDeck(namesCards, deckQuantity)
  val hand1: ListBuffer[Card] = Inicializador.createHand(deck1, handQuantity)
  val deck2: ListBuffer[Card] = Inicializador.createDeck(namesCards, deckQuantity)
  val hand2: ListBuffer[Card] = Inicializador.createHand(deck2, handQuantity)
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
    assertEquals(jugador1.hand_card.length, previousHandLength+1)
>>>>>>> Stashed changes
  }

  test("Dos jugadores son iguales"){
    assert(jugador1.equals(jugador2))
<<<<<<< Updated upstream
    assert(!jugador1.equals(jugador3))
  }

  test("If there is no more cards in the deck and you try to draw one it does not let you") {
    val initial_deck_length = jugador1.deck.length
    val initial_hand_length = jugador1.hand_card.length
    var cont = 0
    while (initial_deck_length - cont != 0) {
=======
    assert(jugador1.equals(jugador3))
    assert(!jugador1.equals(jugador4))
  }

  test("If there is no more cards in the deck and you try to draw one it does not let you") {
    val initialDeckLength = jugador1.deck.length
    val initialHandLength = jugador1.hand_card.length
    var cont = 0
    while (initialDeckLength - cont != 0) {
>>>>>>> Stashed changes
      jugador1.drawCard()
      cont += 1
    }
    jugador1.drawCard()
    assertEquals(jugador1.deck.length, 0)
<<<<<<< Updated upstream
    assertEquals(jugador1.hand_card.length, initial_hand_length + cont)
  }
  test("A player is not a card"){
    val name_list = cards_available.keys.toList
    val name = name_list(0)
    val zone = cards_available(name)
    val carta = new Card(name, zone)
=======
    assertEquals(jugador1.hand_card.length, initialHandLength + cont)
  }
  test("A player is not a card"){
    val aDistanciaCard = new ADistanciaCard(namesADistancia(0), 1)
    val asedioCard = new AsedioCard(namesAsedio(0), 1)

>>>>>>> Stashed changes
    assert(!jugador1.equals(carta))
  }
}
