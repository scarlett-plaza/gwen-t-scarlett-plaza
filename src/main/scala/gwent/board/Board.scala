package cl.uchile.dcc
package gwent.board

import gwent.player.Player

import cl.uchile.dcc.gwent.cards.{ADistanciaCard, AbstractUnitCard, AsedioCard, CuerpoACuerpoCard, WeatherCard}

import java.util.Objects
import scala.collection.mutable.ListBuffer

class Board(players: ListBuffer[Player]) extends Equals{

  private val boardSection: Map[(String, Int), PlayerBoardSection] = players.map{player =>
    val key = (player.name, player.boardSec)
    val boardSection = new PlayerBoardSection(player, player.boardSec)
    key ->boardSection
  }.toMap

  val weatherSection: WeatherBoardSection = new WeatherBoardSection()

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

  def playCard(card: AbstractUnitCard, player: Player): Unit = {
    if (player._hand.contains(card)) {
      val boardSectionOption: Option[PlayerBoardSection] = boardSection.get((player.name, player.boardSec))
      boardSectionOption match {
        case Some(boardSection) =>
          // La clave estaba presente en el mapa, accede a la boardSection
          player._hand-=card
          boardSection.addCard(card)
        case None =>
          // La clave no estaba presente en el mapa
          println("No se encontró ese jugador en esa sección del tablero")
      }
    }
    else{
      println("No puedes usar una carta que no esta en tu mano")
    }
  }
  def playCard(card: WeatherCard, player: Player): Unit = {
    if(player._hand.contains(card)){
      weatherSection.addWeatherCard(card)
      player._hand-=card
    }
  }
}
