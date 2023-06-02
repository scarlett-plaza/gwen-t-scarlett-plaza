package cl.uchile.dcc
package gwent.cards


import cl.uchile.dcc.gwent.board.sections.{ADistanciaSection, AsedioSection, CuerpoACuerpoSection, WeatherSection}

import java.util.Objects

abstract class AbstractUnitCard(val name: String, protected val power: Int) extends Card with Equals {

  var currentPower = power

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[AbstractUnitCard]
  }

  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val otherCard = obj.asInstanceOf[AbstractUnitCard]
      (this eq otherCard) ||
        otherCard.name == name &&
          otherCard.currentPower == currentPower &&
          otherCard.power == power
    }
    else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(name, currentPower, power)
  }

  def addCardToWeather(ws: WeatherSection): Unit

  def addCardToAsedio(ws: AsedioSection): Unit

  def addCardToCuerpoACuerpo(ws: CuerpoACuerpoSection): Unit

  def addCardToADistancia(ws: ADistanciaSection): Unit
}
