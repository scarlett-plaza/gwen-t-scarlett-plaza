package cl.uchile.dcc
package gwent.controlador

import gwent.observer.GameController

class ComienzaRonda extends State {
  didJugadorPass = false
  didComputadoraPass = false

  override def iniciaRonda() = {
    this.changeState(new TurnoJugador())
  }
  override def isJugadorPlaying(): Boolean = true
}
