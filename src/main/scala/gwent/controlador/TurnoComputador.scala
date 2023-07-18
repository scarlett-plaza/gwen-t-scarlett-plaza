package cl.uchile.dcc
package gwent.controlador

class TurnoComputador extends State {
  override def pasaTurno(): Unit = {
    didComputadoraPass = true
    if (didJugadorPass) {
      this.changeState(new FinPartida())
      
    }
    else {
      this.changeState(new TurnoJugador())
    }
  }
  override def juegaCarta(): Unit = {
    if (!didJugadorPass) {
      this.changeState(new TurnoJugador())
    }
  }
  
  override def isComputadoraPlaying(): Boolean = true
  
}
