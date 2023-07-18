package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.Card

import scala.collection.mutable.ListBuffer
/** A class representing an abstract section of the board.
 *
 * @param _section ListBuffer[_ <: Card]
 *
 * @see Board, ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection
 *
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
abstract class Section {
  val _section: ListBuffer[_ <: Card]
}
