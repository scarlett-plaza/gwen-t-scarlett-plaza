package cl.uchile.dcc
package gwent.cards

import gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection}

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.habilidad.AplicaHabilidad
import cl.uchile.dcc.gwent.player.Player

trait Card {
  val name: String
  val habilidad: List[AplicaHabilidad]
  def addToSection(player: Player, board: Board): Unit
}
