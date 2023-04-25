package cl.uchile.dcc
package gwent

import java.util.Objects

/** A class that represents generic cards
 *
 * Cards are represented by their name and zone which they can be played
 * @param name String of name of the card
 * @param zone String of zone where you can play it
 *
 * @example
 * val card = New Card("Copi Copi", "Asedio")
 *
 * @author Scarlett Plaza
 */
class Card(val name: String, val zone: String) extends Equals {

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[Card]
  }
  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val otherCard = obj.asInstanceOf[Card]
      (this eq otherCard) ||
        otherCard.name == name &&
          otherCard.zone == zone
    }
    else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(name, zone)
  }
}
