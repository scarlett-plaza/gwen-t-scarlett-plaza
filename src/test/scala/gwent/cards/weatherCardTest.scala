package cl.uchile.dcc
package gwent.cards

//val wheathercards_available = Map("Pescado" -> "Asedio", "Moneda" -> "Cuerpo a cuerpo", "Lili" -> "Cuerpo a cuerpo",
//  "Calugoso" -> "Asedio", "Pelusa" -> "Cuerpo a cuerpo", "Amigo" -> "Cuerpo a cuerpo",
//  "Calendario" -> "Asedio")

import gwent.player.Player

import cl.uchile.dcc.gwent.board.Inicializador
import cl.uchile.dcc.gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection}
import cl.uchile.dcc.gwent.habilidad.{AplicaHabilidad, ClimaDespejado, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable, NullHabilidad, RefuerzoMoralADistancia, RefuerzoMoralAsedio, RefuerzoMoralCuerpoACuerpo, VinculoEstrechoADistancia, VinculoEstrechoAsedio, VinculoEstrechoCuerpoACuerpo}
import jdk.javadoc.internal.doclets.toolkit.util.DocFile.list
import munit.FunSuite

import scala.collection.mutable.ListBuffer
import munit.Clue.generate

import scala.collection.immutable.List

class weatherCardTest extends FunSuite{
  val refMorADistancia = new AplicaHabilidad("refuerzo moral ADistancia", new RefuerzoMoralADistancia(1))
  val VinEstADistancia = new AplicaHabilidad("Vinculo estrecho ADistancia", new VinculoEstrechoADistancia())
  val NullADistancia = new AplicaHabilidad("refuerzo moral ADistancia", new NullHabilidad())
  val ataquesADistancia: List[AplicaHabilidad] = List(refMorADistancia, VinEstADistancia, NullADistancia)

  val refMorAsedio = new AplicaHabilidad("refuerzo moral asedio", new RefuerzoMoralAsedio(1))
  val VinEstAsedio = new AplicaHabilidad("Vinculo estrecho asedio", new VinculoEstrechoAsedio())
  val NullAsedio = new AplicaHabilidad("refuerzo moral asedio", new NullHabilidad())
  val ataquesAsedio: List[AplicaHabilidad] = List(refMorAsedio, VinEstAsedio, NullAsedio)

  val refMorCuerpoACuerpo = new AplicaHabilidad("refuerzo moral CuerpoACuerpo", new RefuerzoMoralCuerpoACuerpo(1))
  val VinEstCuerpoACuerpo = new AplicaHabilidad("Vinculo estrecho CuerpoACuerpo", new VinculoEstrechoCuerpoACuerpo())
  val NullCuerpoACuerpo = new AplicaHabilidad("refuerzo moral CuerpoACuerpo", new NullHabilidad())
  val ataquesCuerpoACuerpo: List[AplicaHabilidad] = List(refMorCuerpoACuerpo, VinEstCuerpoACuerpo, NullCuerpoACuerpo)

  val lluviaTorrencial = new AplicaHabilidad("lluviaTorrencial", new LluviaTorrencial())
  val nieblaImpenetrable = new AplicaHabilidad("nieblaImpenetrable", new NieblaImpenetrable())
  val escarchaMordiente = new AplicaHabilidad("escarchaMordiente", new EscarchaMordiente())
  val climaDespejado = new AplicaHabilidad("climaDespejado", new ClimaDespejado())
  val ataquesWeather: List[AplicaHabilidad] = List(lluviaTorrencial, nieblaImpenetrable, escarchaMordiente, climaDespejado)

  val namesADistancia: List[String] = List("Elemento", "Chaucha", "Yo no fui", "Neumatex", "Maletin", "Jefe", "Yo soy", "Ro", "Duquesa")
  val cardsADistancia: List[ADistanciaCard] = List.tabulate(namesADistancia.length)(i => new ADistanciaCard(namesADistancia(i), 1, List(ataquesADistancia(i % 3))))
  val namesAsedio: List[String] = List("Copi copi", "Mente en blanco", "Tepo tepo", "Palmerita", "Etcetera", "Rucia", "Guason", "Chu", "James Bond")
  val cardsAsedio: List[AsedioCard] = List.tabulate(namesAsedio.length)(i => new AsedioCard(namesAsedio(i), 1, List(ataquesAsedio(i % 3))))
  val namesCuerpoACuerpo: List[String] = List("Adjetivo", "Coliforme", "Fierro malo", "Cortachurro", "Choapino", "Rata", "Cucky", "Neumatico", "Chamullo")
  val cardsCuerpoACuerpo: List[CuerpoACuerpoCard] = List.tabulate(namesCuerpoACuerpo.length)(i => new CuerpoACuerpoCard(namesCuerpoACuerpo(i), 1, List(ataquesCuerpoACuerpo(i % 3))))
  val namesWeather: List[String] = List("Pescado", "Moneda", "Lili", "Calugoso", "Pelusa", "Amigo", "Calendario")
  val cardsWeather: List[WeatherCard] = List.tabulate(namesWeather.length)(i => new WeatherCard(namesWeather(i), List(ataquesWeather(i % 4))))

  val cardsCards: List[Card] = List.concat(cardsADistancia, cardsAsedio, cardsCuerpoACuerpo, cardsWeather)

  val card1: WeatherCard = new WeatherCard(namesWeather(0), List(ataquesWeather(0)))
  val card2: WeatherCard = new WeatherCard(namesWeather(0), List(ataquesWeather(0)))
  val card3: WeatherCard = new WeatherCard(namesWeather(1), List(ataquesWeather(1)))
  val card4: WeatherCard = new WeatherCard(namesWeather(2), List(ataquesWeather(2)))
  val card5: WeatherCard = new WeatherCard(namesWeather(3), List(ataquesWeather(3)))
  val card6: ADistanciaCard = new ADistanciaCard(namesADistancia(2), 2, List(ataquesADistancia(2)))
  val card7: AsedioCard = new AsedioCard(namesAsedio(2), 2, List(ataquesAsedio(2)))
  val card8: CuerpoACuerpoCard = new CuerpoACuerpoCard(namesCuerpoACuerpo(2), 2, List(ataquesCuerpoACuerpo(2)))

  test("Equal Cards"){
    assert(card1.equals(card2))
    assert(!card1.equals(card3))
  }
  test("A card is not a player") {
    val inicializador = new Inicializador()
    val deck: ListBuffer[Card] = inicializador.createDeck(cardsCards, 25)
    val hand: ListBuffer[Card] = inicializador.createHand(deck, 10)
    val player = new Player("Juan Carlos Bodoque", 2, deck, hand)
    assert(!card1.equals(player))
  }
  test("Comparar hashCode") {
    assert(card1.hashCode.equals(card2.hashCode))
  }
  test("Aplicar habilidades especiales") {
    card1.aplicaHabilidad(0,card7)
    card3.aplicaHabilidad(0,card6)
    card4.aplicaHabilidad(0,card8)
    card5.aplicaHabilidad(0,card2)
    assertEquals(card7.currentPower,1)
    assertEquals(card6.currentPower,1)
    assertEquals(card8.currentPower,1)
    assertEquals(card2.active,false)

  }
}