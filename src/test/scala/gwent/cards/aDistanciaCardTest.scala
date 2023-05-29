package cl.uchile.dcc
package gwent.cards

import gwent.player.Player

import cl.uchile.dcc.gwent.board.Inicializador
import jdk.javadoc.internal.doclets.toolkit.util.DocFile.list
import munit.FunSuite
import scala.collection.mutable.ListBuffer
import munit.Clue.generate

class aDistanciaCardTest extends FunSuite{
  val namesADistancia: List[String] = List("Elemento", "Chaucha", "Yo no fui", "Neumatex", "Maletin", "Jefe", "Yo soy", "Ro", "Duquesa")
  val cardsADistancia: List[ADistanciaCard] = List.tabulate(namesADistancia.length)(i => new ADistanciaCard(namesADistancia(i), 1))
  val namesAsedio: List[String] = List("Copi copi", "Mente en blanco", "Tepo tepo", "Palmerita", "Etcetera", "Rucia", "Guason", "Chu", "James Bond")
  val cardsAsedio: List[AsedioCard] = List.tabulate(namesAsedio.length)(i => new AsedioCard(namesAsedio(i), 1))
  val namesCuerpoACuerpo: List[String] = List("Adjetivo", "Coliforme", "Fierro malo", "Cortachurro", "Choapino", "Rata", "Cucky", "Neumatico", "Chamullo")
  val cardsCuerpoACuerpo: List[CuerpoACuerpoCard] = List.tabulate(namesCuerpoACuerpo.length)(i => new CuerpoACuerpoCard(namesCuerpoACuerpo(i), 1))
  val namesWeather: List[String] = List("Pescado", "Moneda", "Lili", "Calugoso", "Pelusa", "Amigo", "Calendario")
  val cardsWeather: List[WeatherCard] = List.tabulate(namesWeather.length)(i => new WeatherCard(namesWeather(i)))

  val cardsCards: List[Card] = List.concat(cardsADistancia, cardsAsedio, cardsCuerpoACuerpo, cardsWeather)

  val card1: ADistanciaCard = new ADistanciaCard(namesADistancia(0), 1)
  val card2: ADistanciaCard = new ADistanciaCard(namesADistancia(0), 1)
  val card3: ADistanciaCard = new ADistanciaCard(namesADistancia(1), 2)
  test("Equal Cards"){
    assert(card1.equals(card2))
    assert(!card1.equals(card3))
  }
  test("A card is not a player") {
    val inicializador = new Inicializador()
    val deck: ListBuffer[Card] = inicializador.createDeck(cardsCards, 25)
    val hand: ListBuffer[Card] = inicializador.createHand(deck, 10)
    val player = new Player("Juan Carlos Bodoque", 2, deck, hand, 1)
    assert(!card1.equals(player))
  }
}
