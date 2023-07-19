package cl.uchile.dcc
package gwent.observer

import gwent.player.Player
/**
 * GameController is responsible for managing the game and handling updates from players.
 * It implements the Observer interface to receive updates from players.
 *
 * @param players The list of players participating in the game.
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
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
