package cl.uchile.dcc
package gwent.board
import gwent.cards.{ADistanciaCard, AbstractUnitCard, AsedioCard, Card, CuerpoACuerpoCard, WeatherCard}
import gwent.player.Player

import cl.uchile.dcc.gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection}

import java.util.Objects
import scala.collection.mutable.ListBuffer

class Board(val players: List[Player]) extends Equals {

  private val boardSection: Map[Player, (ADistanciaSection, AsedioSection, CuerpoACuerpoSection)] = players.map { player =>
    val key: Player = player
    val aDistanciaSection: ADistanciaSection = new ADistanciaSection(ListBuffer.empty[ADistanciaCard])
    val asedioSection: AsedioSection = new AsedioSection(ListBuffer.empty[AsedioCard])
    val cuerpoACuerpoSection: CuerpoACuerpoSection = new CuerpoACuerpoSection(ListBuffer.empty[CuerpoACuerpoCard])
    key -> (aDistanciaSection, asedioSection, cuerpoACuerpoSection)
  }.toMap

  private val weatherSection: WeatherSection = new WeatherSection(ListBuffer.empty[WeatherCard])

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[Board]
  }
  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val otherBoard = obj.asInstanceOf[Board]
      (this eq otherBoard) ||
        otherBoard.players == players &&
          otherBoard.boardSection == boardSection &&
          otherBoard.weatherSection == weatherSection
    }
    else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(players, boardSection, weatherSection)
  }
  def playUnitCard(card: AbstractUnitCard, player: Player): Unit={
    if(player.hand.contains(card)){
      val boardOption: Option[(aDistanciaSection, asedioSection, cuerpoACuerpoSection)] = boardSection.get(player)
      boardOption match{
        case Some(value) =>
      }
    }
  }
}
