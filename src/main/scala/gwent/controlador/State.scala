package cl.uchile.dcc
package gwent.controlador

class State() {
  private var partida: Option[Partida] = None
  def setPartida(partida: Partida): Unit = {
    this.partida = Some(partida)
  }
  protected def changeState(state: State): Unit = {
    if(partida.isDefined) {
      partida.get.setState(state)
    }
  }
  private def error() = throw new AssertionError("Wrong state")

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
