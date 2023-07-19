package cl.uchile.dcc
package gwent.controlador
/**
 * Class that represents the state of the game when it's the computer's turn to play.
 *
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */

class TurnoComputador extends State {
  /**
   * Passes the turn to the next player. If both players have passed, transitions to the end of the game state.
   */
  override def pasaTurno(): Unit = {
    didComputadoraPass = true
    if (didJugadorPass) {
      this.changeState(new FinPartida())
    }
    else {
      this.changeState(new TurnoJugador())
    }
  }

  /**
   * Plays a card. If the player has not passed, transitions to the player's turn state.
   */
  override def juegaCarta(): Unit = {
    if (!didJugadorPass) {
      this.changeState(new TurnoJugador())
    }
  }
  
  override def isComputadoraPlaying(): Boolean = true
  
}
