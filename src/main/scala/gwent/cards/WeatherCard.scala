package cl.uchile.dcc
package gwent.cards

import java.util.Objects

class WeatherCard(val name: String) extends Card with Equals {

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[Card]
  }
  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val otherCard = obj.asInstanceOf[Card]
      (this eq otherCard) ||
        otherCard.name == name
    }
    else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(name)
  }
}
