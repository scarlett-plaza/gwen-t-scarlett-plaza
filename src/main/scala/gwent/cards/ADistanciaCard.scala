package cl.uchile.dcc
package gwent.cards

import gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection}
/** A class representing the aDistancia cards in the game GWENT.
 *
 * @param name String of the name of the card
 * @param power Int of the power of the card
 *
 * @constructor Creates a new ADistanciaCard with the given name and power
 *
 * @example {{{
 *          val aDistanciaCard = new ADistanciaCard("Elemento", 1)
 *          }}}
 *
 * @see AbstractUnitCard
 *
 * @author Scarlett Plaza
 * @since 1.5
 * @version 2.0
 */
class ADistanciaCard (name: String, power: Int) extends AbstractUnitCard (name, power){
  def addCardToWeather(zone: WeatherSection): Unit = {val hola: Int = 0}

  def addCardToAsedio(zone: AsedioSection): Unit= {val hola: Int = 0}

  def addCardToCuerpoACuerpo(zone: CuerpoACuerpoSection): Unit= {val hola: Int = 0}

  def addCardToADistancia(zone: ADistanciaSection): Unit = {
    zone.section.append(this)
  }
}

