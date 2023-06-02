package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.Card
/** A class representing an abstract section of the board.
 *
 * @param section Any
 *
 * @see Board, ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection
 *
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
abstract class Section {
  val section: Any
  def addCard(that: Card): Unit
}
