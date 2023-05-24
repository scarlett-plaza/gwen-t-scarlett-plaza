package cl.uchile.dcc
package gwent.cards

import gwent.player.Player

import jdk.javadoc.internal.doclets.toolkit.util.DocFile.list
import munit.FunSuite

import scala.collection.mutable.ListBuffer

val namesADistancia: List[ADistanciaCard] = list("Elemento", "Chaucha", "Yo no fui", "Neumatex", "Maletin", "Jefe", "Yo soy", "Ro", "Duquesa")
val namesAsedio: List[AsedioCard] = list("Copi copi", "Mente en blanco", "Tepo tepo", "Palmerita", "Etcetera", "Rucia", "Guason", "Chu", "James Bond")
val namesCuerpoACuerpo: List[CuerpoACuerpoCard] = list("Adjetivo", "Coliforme", "Fierro malo", "Cortachurro", "Choapino", "Rata", "Cucky", "Neumatico", "Chamullo")
val namesWeather: List[WeatherCard] = list("Pescado", "Moneda", "Lili", "Calugoso", "Pelusa", "Amigo", "Calendario")

val namesCards: List[Card] = List.concat(namesADistancia, namesAsedio, namesCuerpoACuerpo, namesWeather)

class aDistanciaCardTest extends FunSuite{
  val card1: ADistanciaCard = new ADistanciaCard(namesADistancia(0), 1)
  val card2: ADistanciaCard = new ADistanciaCard(namesADistancia(0), 1)
  val card3: ADistanciaCard = new ADistanciaCard(namesADistancia(1), 2)
  test("Equal Cards"){
    assert(card1.equals(card2))
    assert(!card1.equals(card3))
  }
  test("A card is not a player")
  val deck: ListBuffer[Card] = Inicializador.createDeck(namesCards, 25)
  val hand: ListBuffer[Card] = Inicializador.createHand(deck, 10)
  val player = new Player("Juan Carlos Bodoque", 2, deck, hand, 1)
  assert(!card1.equals(jugador1))
}
