package cl.uchile.dcc
package gwent.cards

import gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection}
/** A class representing the CuerpoACuerpo cards in the game GWENT.
 *
 * @param name String of the name of the card
 * @param power Int of the power of the card
 *
 * @constructor Creates a new CuerpoACuerpoCard with the given name and power
 *
 * @example {{{
 *          val cuerpoACuerpoCard = new CuerpoACuerpoCard("Adjetivo", 1)
 *          }}}
 *
 * @see AbstractUnitCard
 *
 * @author Scarlett Plaza
 * @since 1.5
 * @version 2.0
 */
class CuerpoACuerpoCard (name: String, power: Int) extends AbstractUnitCard(name, power) {
  hola = 2
  def addCardToADistancia(zone: ADistanciaSection): Unit = hola = 0
  def addCardToAsedio(zone: AsedioSection): Unit = hola = 1
  def addCardToCuerpoACuerpo(zone: CuerpoACuerpoSection): Unit = {
    zone.section.append(this)}
  def addCardToWeather(zone: WeatherSection): Unit = hola = -1
}
