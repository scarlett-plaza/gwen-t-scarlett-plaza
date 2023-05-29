package cl.uchile.dcc
package gwent.board

import gwent.cards.{ADistanciaCard, AsedioCard, Card, CuerpoACuerpoCard, WeatherCard}

trait Section {
  val section: Any
  def addCard(that: Section): Unit
  def addCardTo(that: ADistanciaCard): Unit
  def addCardTo(that: AsedioCard): Unit
  def addCardTo(that: CuerpoACuerpoCard): Unit
  def addCardTo(that: WeatherCard): Unit
}
