package cl.uchile.dcc
package gwent.board
import gwent.cards.{ADistanciaCard, AsedioCard, Card, CuerpoACuerpoCard, WeatherCard}

import gwent.player.Player
import java.util.Objects
import scala.collection.mutable.ListBuffer

class Board(val players: List[Player]) extends Equals {

  val namesWeather: List[String] = List("Pescado", "Moneda", "Lili", "Calugoso", "Pelusa", "Amigo", "Calendario")
  val cardsWeather: List[WeatherCard] = List.tabulate(namesWeather.length)(i => new WeatherCard(namesWeather(i)))

  private val boardSection: Map[String, PlayerBoard] = players.map { player =>
    val key = player.name
    val boardSection = new PlayerBoard(player)
    key -> boardSection
  }.toMap

  val weatherSection: WeatherSection = new WeatherSection(cardsWeather(1))
  val sectionWeather: ListBuffer[WeatherCard] = weatherSection.sectionWeather
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

}
