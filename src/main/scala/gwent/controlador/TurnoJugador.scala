package cl.uchile.dcc
package gwent.controlador

class TurnoJugador extends State {
  override def pasaTurno(): Unit = {
    didJugadorPass = true
    if (didComputadoraPass){
      this.changeState(new FinPartida())
    }
    else{
      this.changeState(new TurnoComputador())
    }
  }
  override def juegaCarta(): Unit = {
    if (!didComputadoraPass){
      this.changeState(new TurnoComputador())
    }
  }
  
  override def isJugadorPlaying(): Boolean = true
}
