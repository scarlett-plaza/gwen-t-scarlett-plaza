package cl.uchile.dcc
package gwent.cards

import gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection}
/** A class representing the asedio cards in the game GWENT.
 *
 * @param name String of the name of the card
 * @param power Int of the power of the card
 *
 * @constructor Creates a new AsedioCard with the given name and power
 *
 * @example {{{
 *          val asedioCard = new AseidoCard("Copi copi", 1)
 *          }}}
 *
 * @see AbstractUnitCard
 *
 * @author Scarlett Plaza
 * @since 1.5
 * @version 2.0
 */
class AsedioCard (name: String, power: Int) extends AbstractUnitCard (name, power){
  hola = 1
  def addCardToWeather(zone: WeatherSection): Unit= {hola = -1}

  def addCardToAsedio(zone: AsedioSection): Unit= {
    zone.section.append(this)
  }
  def addCardToCuerpoACuerpo(zone: CuerpoACuerpoSection): Unit= {hola = 2}
  def addCardToADistancia(zone: ADistanciaSection): Unit= {hola= 0}
}