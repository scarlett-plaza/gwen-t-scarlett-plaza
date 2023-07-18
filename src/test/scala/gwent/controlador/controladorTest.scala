package cl.uchile.dcc
package gwent.controlador


import gwent.player.Player

import cl.uchile.dcc.gwent.board.Inicializador
import cl.uchile.dcc.gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection}
import cl.uchile.dcc.gwent.habilidad.{AplicaHabilidad, ClimaDespejado, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable, NullHabilidad, RefuerzoMoralADistancia, RefuerzoMoralAsedio, RefuerzoMoralCuerpoACuerpo, VinculoEstrechoADistancia, VinculoEstrechoAsedio, VinculoEstrechoCuerpoACuerpo}
import jdk.javadoc.internal.doclets.toolkit.util.DocFile.list
import munit.FunSuite

import scala.collection.mutable.ListBuffer
import munit.Clue.generate

import scala.collection.immutable.List
import scala.language.postfixOps


class controladorTest extends FunSuite {
  test("Partida"){
    val partida: Partida = new Partida()
    assert(!partida.isJugadorPlaying())
    partida.iniciaJuego()
    assert(partida.isJugadorPlaying())
    partida.iniciaRonda()
    assert(partida.isJugadorPlaying())
    partida.juegaCarta()
    assert(!partida.isJugadorPlaying())
    assert(partida.isComputadoraPlaying())
    partida.juegaCarta()
    assert(!partida.isComputadoraPlaying())
    assert(partida.isJugadorPlaying())
    partida.pasaTurno()
    assert(!partida.isJugadorPlaying())
    assert(partida.isComputadoraPlaying())
    partida.pasaTurno()
    assert(!partida.isPartidaOver())
  }
  test("Error debe mandar un assertion error al hacer jugar carta sin inicial el juego"){
    val partida: Partida = new Partida()
    val exception = intercept[AssertionError]{
      partida.juegaCarta()
    }
    assertEquals(exception.getMessage(), "Wrong state")
  }
  test("Error debe mandar un assertion error al hacer iniciar ronda sin inicial el juego") {
    val partida: Partida = new Partida()
    val exception = intercept[AssertionError] {
      partida.iniciaRonda()
    }
    assertEquals(exception.getMessage(), "Wrong state")
  }
  test("Error debe mandar un assertion error al hacer pasa turno sin inicial el juego") {
    val partida: Partida = new Partida()
    val exception = intercept[AssertionError] {
      partida.pasaTurno()
    }
    assertEquals(exception.getMessage(), "Wrong state")
  }
}
