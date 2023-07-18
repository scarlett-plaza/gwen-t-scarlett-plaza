package cl.uchile.dcc
package gwent.board
import gwent.cards.{ADistanciaCard, AbstractUnitCard, AsedioCard, Card, CuerpoACuerpoCard, WeatherCard}
import gwent.player.Player

import cl.uchile.dcc.gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection}

import java.util.Objects
import scala.collection.mutable.ListBuffer
/** A class representing the board of the game, it contains the sections ADistancia, Asedio and CuerpoACuerpo for each
 *  player of the board and the weather section
 *
 * @param players the list of players of that will play
 *
 * @constructor Creates a new ADistanciaSection with the given listBuffer of cards
 *
 * @example {{{
 *          val Board = new Board(List[Player])
 *          }}}
 *
 * @see Board
 *
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
class Board(val players: List[Player]) extends Equals {

  val boardSection: Map[Player, (ADistanciaSection, AsedioSection, CuerpoACuerpoSection)] = players.map { player =>
    val key: Player = player
    val aDistanciaSection: ADistanciaSection = new ADistanciaSection(ListBuffer.empty[ADistanciaCard])
    val asedioSection: AsedioSection = new AsedioSection(ListBuffer.empty[AsedioCard])
    val cuerpoACuerpoSection: CuerpoACuerpoSection = new CuerpoACuerpoSection(ListBuffer.empty[CuerpoACuerpoCard])
    key -> (aDistanciaSection, asedioSection, cuerpoACuerpoSection)
  }.toMap

  val weatherSection: WeatherSection = new WeatherSection(ListBuffer.empty[WeatherCard])

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[Board]
  }
  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val otherBoard = obj.asInstanceOf[Board]
      (this eq otherBoard) ||
        otherBoard.players == players &&
          otherBoard.weatherSection == weatherSection &&
          otherBoard.boardSection.forall{case (player, (aDistancia1, asedio1, cuerpoACuerpo1)) =>
            boardSection.get(player) match {
              case Some((aDistancia2, asedio2, cuerpoACuerpo2)) =>
                aDistancia1 == aDistancia2 &&
                  asedio1 == asedio2 &&
                  cuerpoACuerpo1 == cuerpoACuerpo2
            }
          }
    }
    else {false}
  }

  override def hashCode(): Int = {
    Objects.hash(players, boardSection, weatherSection)
  }

  def playCard(card: Card, player: Player): Unit={
    card.addToSection(player, this)
  }

  def addToAsedioSection(card: AsedioCard, player: Player): Unit = {
    boardSection.get(player) match {
      case Some((_, asedioSection, _)) => asedioSection.section.append(card)
      case None => throw new Exception("Player not found")
    }
  }

  def addToADistanciaSection(card: ADistanciaCard, player: Player): Unit = {
    boardSection.get(player) match {
      case Some((aDistanciaSection, _, _)) => aDistanciaSection.section.append(card)
      case None => throw new Exception("Player not found")
    }
  }

  def addToCuerpoACuerpoSection(card: CuerpoACuerpoCard, player: Player): Unit = {
    boardSection.get(player) match {
      case Some((_, _, cuerpoACuerpoSection)) => cuerpoACuerpoSection.section.append(card)
      case None => throw new Exception("Player not found")
    }
  }

  def addToWeatherSection(card: WeatherCard, player: Player): Unit = {
    boardSection.get(player) match {
      case Some((_, _, _)) => weatherSection.section.append(card)
      case None => throw new Exception("Player not found")
    }
  }
}
