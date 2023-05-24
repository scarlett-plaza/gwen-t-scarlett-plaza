package cl.uchile.dcc
package gwent.board


import cl.uchile.dcc.gwent.cards.WeatherCard

import scala.collection.mutable.ListBuffer

class WeatherBoardSection {
 val sectionWeather: ListBuffer[WeatherCard] = ListBuffer.empty[WeatherCard]
 def addCard(card: WeatherCard): Unit = {
   sectionWeather.append(card)
 }
}
