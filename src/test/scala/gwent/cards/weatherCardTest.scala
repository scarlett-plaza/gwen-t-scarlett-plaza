package cl.uchile.dcc
package gwent.cards

//val wheathercards_available = Map("Pescado" -> "Asedio", "Moneda" -> "Cuerpo a cuerpo", "Lili" -> "Cuerpo a cuerpo",
//  "Calugoso" -> "Asedio", "Pelusa" -> "Cuerpo a cuerpo", "Amigo" -> "Cuerpo a cuerpo",
//  "Calendario" -> "Asedio")

import gwent.player.{Player, PlayerFactory}

import cl.uchile.dcc.gwent.board.Inicializador
import cl.uchile.dcc.gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection}
import cl.uchile.dcc.gwent.habilidad.{AplicaHabilidad, ClimaDespejado, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable, NullHabilidad, RefuerzoMoralADistancia, RefuerzoMoralAsedio, RefuerzoMoralCuerpoACuerpo, VinculoEstrechoADistancia, VinculoEstrechoAsedio, VinculoEstrechoCuerpoACuerpo}
import jdk.javadoc.internal.doclets.toolkit.util.DocFile.list
import munit.FunSuite

import scala.collection.mutable.ListBuffer
import munit.Clue.generate

import scala.collection.immutable.List

class weatherCardTest extends FunSuite{
  val namesADistancia: List[String] = List("Elemento", "Chaucha", "Yo no fui", "Neumatex", "Maletin", "Jefe", "Yo soy", "Ro", "Duquesa")
  val namesAsedio: List[String] = List("Copi copi", "Mente en blanco", "Tepo tepo", "Palmerita", "Etcetera", "Rucia", "Guason", "Chu", "James Bond")
  val namesCuerpoACuerpo: List[String] = List("Adjetivo", "Coliforme", "Fierro malo", "Cortachurro", "Choapino", "Rata", "Cucky", "Neumatico", "Chamullo")
  val namesWeather: List[String] = List("Pescado", "Moneda", "Lili", "Calugoso", "Pelusa", "Amigo", "Calendario")

  val cardFactory = new CardFactory()

  val card1: WeatherCard = cardFactory(namesWeather(0))
  val card2: WeatherCard = cardFactory(namesWeather(0))
  val card3: WeatherCard = cardFactory(namesWeather(1))
  val card4: WeatherCard = cardFactory(namesWeather(2))
  val card5: WeatherCard = cardFactory(namesWeather(3))
  val card6: ADistanciaCard = cardFactory(namesADistancia(2))
  val card7: AsedioCard = cardFactory(namesAsedio(2))
  val card8: CuerpoACuerpoCard = cardFactory(namesCuerpoACuerpo(2))

  test("Equal Cards"){
    assert(card1.equals(card2))
    assert(!card1.equals(card3))
  }
  test("A card is not a player") {
    val playerFactory = new PlayerFactory()
    val player = playerFactory("Juan Carlos Bodoque", 25, 10, 2)
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
  test("the card factory doesn't create a card wich name is not registered"){
    val exception = intercept[Exception]{
      cardFactory("Mario Hugo")
    }
    assertEquals(exception.getMessage(), "No existe la carta")
  }
}