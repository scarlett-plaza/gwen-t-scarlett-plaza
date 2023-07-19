package cl.uchile.dcc
package gwent.controlador

import gwent.cards.Card

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.player.Player

import scala.collection.mutable.ListBuffer
/** Class that represents a game session of the game
 *
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
class Partida() {
  
  private var state: State = new ComienzaPartida()
  state.setPartida(this)
  
  def setState(aState: State): Unit = {
    state = aState
    state.setPartida(this)
  }

  /**
   * Initiates the game.
   */
  def iniciaJuego():Unit = state.iniciaJuego()

  /**
   * initiates a round.
   */
  def iniciaRonda():Unit = state.iniciaRonda()

  /**
   * plays a card.
   */
  def juegaCarta():Unit = state.juegaCarta()

  /**
   * passes the turn.
   */
  def pasaTurno():Unit = state.pasaTurno()

  /**
   * indicates if the player is playing.
   * @return true if the player is playing, false otherwise.
   */
  def isJugadorPlaying():Boolean = state.isJugadorPlaying()

  /**
   * indicates if the computer is playing.
   * @return true if the computer is playing, false otherwise.
   */
  def isComputadoraPlaying():Boolean = state.isComputadoraPlaying()
  /**
   * indicates if the game is over.
   * @return true if the game is over, false otherwise.
   */
  def isPartidaOver():Boolean = state.isPartidaOver()
  protected var didJugadorPass:Boolean = state.didJugadorPass
  protected var didComputadoraPass:Boolean = state.didComputadoraPass
}
