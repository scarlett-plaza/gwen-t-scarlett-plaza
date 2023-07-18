package cl.uchile.dcc
package gwent.observer

import gwent.player.Player

class GameController (private val players: List[Player]) extends Observer{
  for ( player <- players) {
    player.addObserver(this)
  }
  override def update(subject: ISubject, response: Any): Unit = {
    if(response.isInstanceOf[LoseCondition]){
      val loseCondition = response.asInstanceOf[LoseCondition]
    }
  }
}
