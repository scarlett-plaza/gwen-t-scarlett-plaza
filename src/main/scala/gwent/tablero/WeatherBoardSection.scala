package cl.uchile.dcc
package gwent.tablero

import gwent.cards.WeatherCard

class WeatherBoardSection() {
  var weatherSection: ListBuffer[WeatherCard]
  def addWeatherCard(card: WeatherCard): Unit = {
    weatherSection.append(card)
  }
}
