package cl.uchile.dcc
package gwent.board

import gwent.cards.{ADistanciaCard, AsedioCard, CuerpoACuerpoCard}

import cl.uchile.dcc.gwent.player.Player

import scala.collection.mutable.ListBuffer

class PlayerBoardSection(val player:Player, board: Int) {
  val sectionAsedio: ListBuffer[AsedioCard]
  val sectionADistancia: ListBuffer[ADistanciaCard]
  val sectionCuerpoACuerpo: ListBuffer[CuerpoACuerpoCard]

  def addCard(card: AsedioCard): Unit = {
    sectionAsedio.append(card)
  }

  def addCard(card: ADistanciaCard): Unit = {
    sectionADistancia.append(card)
  }

  def addCard(card: CuerpoACuerpoCard): Unit = {
    sectionCuerpoACuerpo.append(card)
  }
}
