package cl.uchile.dcc
package gwent.board

import gwent.cards.{ADistanciaCard, AsedioCard, Card, CuerpoACuerpoCard, WeatherCard}

import cl.uchile.dcc.gwent.player.Player

import scala.collection.mutable.ListBuffer

class PlayerBoard(val player: Player) {

  val namesADistancia: List[String] = List("Elemento", "Chaucha", "Yo no fui", "Neumatex", "Maletin", "Jefe", "Yo soy", "Ro", "Duquesa")
  val cardsADistancia: List[ADistanciaCard] = List.tabulate(namesADistancia.length)(i => new ADistanciaCard(namesADistancia(i), 1))
  val namesAsedio: List[String] = List("Copi copi", "Mente en blanco", "Tepo tepo", "Palmerita", "Etcetera", "Rucia", "Guason", "Chu", "James Bond")
  val cardsAsedio: List[AsedioCard] = List.tabulate(namesAsedio.length)(i => new AsedioCard(namesAsedio(i), 1))
  val namesCuerpoACuerpo: List[String] = List("Adjetivo", "Coliforme", "Fierro malo", "Cortachurro", "Choapino", "Rata", "Cucky", "Neumatico", "Chamullo")
  val cardsCuerpoACuerpo: List[CuerpoACuerpoCard] = List.tabulate(namesCuerpoACuerpo.length)(i => new CuerpoACuerpoCard(namesCuerpoACuerpo(i), 1))
  val namesWeather: List[String] = List("Pescado", "Moneda", "Lili", "Calugoso", "Pelusa", "Amigo", "Calendario")
  val cardsWeather: List[WeatherCard] = List.tabulate(namesWeather.length)(i => new WeatherCard(namesWeather(i)))

  val cardsCards: List[Card] = List.concat(cardsADistancia, cardsAsedio, cardsCuerpoACuerpo, cardsWeather)

  val asedio: AsedioSection = new AsedioSection(cardsAsedio(1), player)
  val sectionAsedio: ListBuffer[AsedioCard] = asedio.sectionAsedio
  val aDistancia: ADistanciaSection = new ADistanciaSection(cardsADistancia(1), player)
  val sectionADistancia: ListBuffer[ADistanciaCard] = aDistancia.sectionADistancia
  val cuerpoACuerpo: CuerpoACuerpoSection = new CuerpoACuerpoSection(cardsCuerpoACuerpo(1), player)
  val sectionCuerpoACuerpo: ListBuffer[CuerpoACuerpoCard] = cuerpoACuerpo.sectionCuerpoACuerpo
}
