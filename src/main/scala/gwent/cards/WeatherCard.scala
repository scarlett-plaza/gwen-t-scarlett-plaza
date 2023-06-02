package cl.uchile.dcc
package gwent.cards

import cl.uchile.dcc.gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, Section, WeatherSection}

import java.util.Objects

class WeatherCard(override val name: String) extends Card with Equals {
  
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

  def addCardToWeather(zone: WeatherSection):Unit = {
    zone.section.append(this)
  }

  def addCardToAsedio(zone: AsedioSection): Unit = {???}

  def addCardToCuerpoACuerpo(zone: CuerpoACuerpoSection): Unit = {???}

  def addCardToADistancia(zone: ADistanciaSection): Unit = {???}
}
