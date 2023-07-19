package cl.uchile.dcc
package gwent.controlador
/**
 * Class that represents the state of the game when it's the player's turn to play.
 *
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
class TurnoJugador extends State {
  /**
   * Passes the turn to the computer. If both players have passed, transitions to the end of the game state.
   */
  override def pasaTurno(): Unit = {
    didJugadorPass = true
    if (didComputadoraPass){
      this.changeState(new FinPartida())
    }
    else{
      this.changeState(new TurnoComputador())
    }
  }

  /**
   * Plays a card. If the computer has not passed, transitions to the computer's turn state.
   */
  override def juegaCarta(): Unit = {
    if (!didComputadoraPass){
      this.changeState(new TurnoComputador())
    }
  }
  
  override def isJugadorPlaying(): Boolean = true
}
