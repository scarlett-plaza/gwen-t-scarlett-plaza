package cl.uchile.dcc
package gwent

/** A class that represent Unit cards that have an ability
 *
 * @param name The name of the card
 * @param zone The zone where you have to play it
 * @param strength A number that represents the strength of the card
 * @param ability A string that represents the ability of the card
 *
 * @example
 * val card = New AbilityUnitCard("Coliforme", "Cuerpo a cuerpo", 10, "Refuerzo moral"
 *
 * @author Scarlett Plaza
 */

class AbilityUnitCard(name: String, zone: String, strength: Int, val ability: String) extends UnitCard(name, zone, strength) {

}
