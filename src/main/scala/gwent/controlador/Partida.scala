package cl.uchile.dcc
package gwent.controlador

import gwent.cards.Card

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.player.Player

import scala.collection.mutable.ListBuffer

class Partida() {
  
  private var state: State = new ComienzaPartida()
  state.setPartida(this)
  
  def setState(aState: State): Unit = {
    state = aState
    state.setPartida(this)
  }
  
  def iniciaJuego():Unit = state.iniciaJuego()
  def iniciaRonda():Unit = state.iniciaRonda()
  def juegaCarta():Unit = state.juegaCarta()
  def pasaTurno():Unit = state.pasaTurno()
  
  def isJugadorPlaying():Boolean = state.isJugadorPlaying()
  def isComputadoraPlaying():Boolean = state.isComputadoraPlaying()
  def isPartidaOver():Boolean = state.isPartidaOver()
  protected var didJugadorPass:Boolean = state.didJugadorPass
  protected var didComputadoraPass:Boolean = state.didComputadoraPass
}
