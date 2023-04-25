package cl.uchile.dcc
package gwent

import munit.FunSuite

import scala.collection.mutable.ListBuffer

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


class CardTest extends FunSuite{
  val name_list = cards_available.keys.toList
  val name = name_list(0)
  val zone = cards_available(name)
  val carta = new Card(name, zone)
  val name_list1 = cards_available.keys.toList
  val name1 = name_list(0)
  val zone1 = cards_available(name1)
  val carta1 = new Card(name1, zone1)
  val name_list2 = cards_available.keys.toList
  val name2 = name_list(2)
  val zone2 = cards_available(name2)
  val carta2 = new Card(name2, zone2)
  test("Equal cards") {
    assert(carta.equals(carta1))
    assert(!carta.equals(carta2))
  }
  test("A card is not a player"){
    val nombre1 = "Juan Carlos Bodoque"
    val seccion1 = 1
    val jugador1 = new Player(nombre1, seccion1)
    assert(!carta.equals(jugador1))
  }
}

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
    jugador1.draw_card()
    assertEquals(jugador1.deck.length, previous_deck_length-1)
    assertEquals(jugador1.hand_card.length, previous_hand_length+1)
  }

  test("Dos jugadores son iguales"){
    assert(jugador1.equals(jugador2))
    assert(!jugador1.equals(jugador3))
  }

  test("If there is no more cards in the deck and you try to draw one it does not let you") {
    val initial_deck_length = jugador1.deck.length
    val initial_hand_length = jugador1.hand_card.length
    var cont = 0
    while (initial_deck_length - cont != 0) {
      jugador1.draw_card()
      cont += 1
    }
    jugador1.draw_card()
    assertEquals(jugador1.deck.length, 0)
    assertEquals(jugador1.hand_card.length, initial_hand_length + cont)
  }
  test("A player is not a card"){
    val name_list = cards_available.keys.toList
    val name = name_list(0)
    val zone = cards_available(name)
    val carta = new Card(name, zone)
    assert(!jugador1.equals(carta))
  }
}
