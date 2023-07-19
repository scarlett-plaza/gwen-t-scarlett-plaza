package cl.uchile.dcc
package gwent.cards

import gwent.player.{Player, PlayerFactory}

import cl.uchile.dcc.gwent.board.Inicializador
import cl.uchile.dcc.gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection}
import cl.uchile.dcc.gwent.habilidad.{AplicaHabilidad, ClimaDespejado, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable, NullHabilidad, RefuerzoMoralADistancia, RefuerzoMoralAsedio, RefuerzoMoralCuerpoACuerpo, VinculoEstrechoADistancia, VinculoEstrechoAsedio, VinculoEstrechoCuerpoACuerpo}
import jdk.javadoc.internal.doclets.toolkit.util.DocFile.list
import munit.FunSuite

import scala.collection.mutable.ListBuffer
import scala.util.Random

class cuerpoACuerpoCardTest extends FunSuite{
  val namesCuerpoACuerpo: List[String] = List("Adjetivo", "Coliforme", "Fierro malo", "Cortachurro", "Choapino", "Rata", "Cucky", "Neumatico", "Chamullo")

  val cardFactory = new CardFactory()
  val card1: CuerpoACuerpoCard = cardFactory(namesCuerpoACuerpo(0))
  val card2: CuerpoACuerpoCard = cardFactory(namesCuerpoACuerpo(0))
  val card3: CuerpoACuerpoCard = cardFactory(namesCuerpoACuerpo(1))
  val card4: CuerpoACuerpoCard = cardFactory(namesCuerpoACuerpo(2))

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
    card1.aplicaHabilidad(0, card2)
    assertEquals(card2.currentPower, 2)
    card3.aplicaHabilidad(0, card1)
    assertEquals(card1.currentPower, 4)
    card4.aplicaHabilidad(0, card1)
    assertEquals(card1.currentPower, 4)
  }
}