package cl.uchile.dcc
package gwent.cards

import gwent.player.{Player, PlayerFactory}

import cl.uchile.dcc.gwent.board.Inicializador
import cl.uchile.dcc.gwent.cards
import cl.uchile.dcc.gwent.habilidad.{AplicaHabilidad, ClimaDespejado, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable, NullHabilidad, RefuerzoMoralADistancia, RefuerzoMoralAsedio, RefuerzoMoralCuerpoACuerpo, VinculoEstrechoADistancia, VinculoEstrechoAsedio, VinculoEstrechoCuerpoACuerpo}
import jdk.javadoc.internal.doclets.toolkit.util.DocFile.list
import munit.FunSuite

import scala.collection.mutable.ListBuffer
import munit.Clue.generate

import scala.util.Random

class asedioCardTest extends FunSuite{
  val namesAsedio: List[String] = List("Copi copi", "Mente en blanco", "Tepo tepo", "Palmerita", "Etcetera", "Rucia", "Guason", "Chu", "James Bond")

  val cardFactory = new CardFactory()
  val card1: AsedioCard = cardFactory(namesAsedio(0))
  val card2: AsedioCard = cardFactory(namesAsedio(0))
  val card3: AsedioCard = cardFactory(namesAsedio(1))
  val card4: AsedioCard = cardFactory(namesAsedio(2))

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