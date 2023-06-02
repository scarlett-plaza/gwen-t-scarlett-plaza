package cl.uchile.dcc
package gwent.cards

import gwent.player.Player

import cl.uchile.dcc.gwent.board.Inicializador
import cl.uchile.dcc.gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection}
import jdk.javadoc.internal.doclets.toolkit.util.DocFile.list
import munit.FunSuite

import scala.collection.mutable.ListBuffer

class CuerpoACuerpoCardTest extends FunSuite{

  val namesADistancia: List[String] = List("Elemento", "Chaucha", "Yo no fui", "Neumatex", "Maletin", "Jefe", "Yo soy", "Ro", "Duquesa")
  val cardsADistancia: List[ADistanciaCard] = List.tabulate(namesADistancia.length)(i => new ADistanciaCard(namesADistancia(i), 1))
  val namesAsedio: List[String] = List("Copi copi", "Mente en blanco", "Tepo tepo", "Palmerita", "Etcetera", "Rucia", "Guason", "Chu", "James Bond")
  val cardsAsedio: List[AsedioCard] = List.tabulate(namesAsedio.length)(i => new AsedioCard(namesAsedio(i), 1))
  val namesCuerpoACuerpo: List[String] = List("Adjetivo", "Coliforme", "Fierro malo", "Cortachurro", "Choapino", "Rata", "Cucky", "Neumatico", "Chamullo")
  val cardsCuerpoACuerpo: List[CuerpoACuerpoCard] = List.tabulate(namesCuerpoACuerpo.length)(i => new CuerpoACuerpoCard(namesCuerpoACuerpo(i), 1))
  val namesWeather: List[String] = List("Pescado", "Moneda", "Lili", "Calugoso", "Pelusa", "Amigo", "Calendario")
  val cardsWeather: List[WeatherCard] = List.tabulate(namesWeather.length)(i => new WeatherCard(namesWeather(i)))

  val cardsCards: List[Card] = List.concat(cardsADistancia, cardsAsedio, cardsCuerpoACuerpo, cardsWeather)

  val card1: CuerpoACuerpoCard = new CuerpoACuerpoCard(namesCuerpoACuerpo(0), 1)
  val card2: CuerpoACuerpoCard = new CuerpoACuerpoCard(namesCuerpoACuerpo(0), 1)
  val card3: CuerpoACuerpoCard = new CuerpoACuerpoCard(namesCuerpoACuerpo(1), 2)
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
  test("Comparar hashCode") {
    assert(card1.hashCode.equals(card2.hashCode))
  }
  test("AddCard_ de una sección que no corresponde a la carta es un dummy function que redefine una variable hola con un Int") {
    val cardWeather = new WeatherCard("Pescado")
    val cardADistancia = new ADistanciaCard("Elemento", 1)
    val cardAsedio = new AsedioCard("Copi copi", 1)
    val cardCuerpoACuerpo = new CuerpoACuerpoCard("Adjetivo", 1)
    val weatherSection = new WeatherSection(ListBuffer.empty[WeatherCard])
    val aDistanciaSection = new ADistanciaSection(ListBuffer.empty[ADistanciaCard])
    val asedioSection = new AsedioSection(ListBuffer.empty[AsedioCard])
    val cuerpoACuerpoSection = new CuerpoACuerpoSection(ListBuffer.empty[CuerpoACuerpoCard])
    assert(cardCuerpoACuerpo.hola == 2)
    cardCuerpoACuerpo.addCardToAsedio(asedioSection)
    assert(cardCuerpoACuerpo.hola == 1)
    cardCuerpoACuerpo.addCardToADistancia(aDistanciaSection)
    assert(cardCuerpoACuerpo.hola == 0)
    cardCuerpoACuerpo.addCardToWeather(weatherSection)
    assert(cardCuerpoACuerpo.hola == -1)
  }
}