package cl.uchile.dcc
package gwent.controlador

/**
 * Class that represents the state of the game.
 * @constructor creates a state.
 * 
 * @see Partida
 * 
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
class State() {
  private var partida: Option[Partida] = None

  /**
   * Sets the partida of the state.
   * @param partida
   */
  def setPartida(partida: Partida): Unit = {
    this.partida = Some(partida)
  }

  /**
   * Changes the state of the partida.
   * @param state
   */
  protected def changeState(state: State): Unit = {
    if(partida.isDefined) {
      partida.get.setState(state)
    }
  }

  /**
   * Throws an error if the state is not correct.
   * @return
   */
  private def error() = throw new AssertionError("Wrong state")

  /**
   * Methods that are implemented in the subclasses.
   */
  def iniciaJuego():Unit = error()
  def iniciaRonda(): Unit = error()
  def juegaCarta(): Unit = error()
  def pasaTurno(): Unit = error()
  
  def isJugadorPlaying(): Boolean = false
  def isComputadoraPlaying(): Boolean = false
  def isPartidaOver(): Boolean = false
  var didJugadorPass: Boolean = false
  var didComputadoraPass: Boolean = false
}
