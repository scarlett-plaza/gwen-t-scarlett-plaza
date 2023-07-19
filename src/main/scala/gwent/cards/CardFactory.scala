package cl.uchile.dcc
package gwent.cards

import gwent.habilidad.{AplicaHabilidad, ClimaDespejado, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable, NullHabilidad, RefuerzoMoralADistancia, RefuerzoMoralAsedio, RefuerzoMoralCuerpoACuerpo, VinculoEstrechoADistancia, VinculoEstrechoAsedio, VinculoEstrechoCuerpoACuerpo}

/** A factory class in charge of creating cards considering a list of cards that can be crated matchin the names
 *  all the card names are Mario Hugo's dogs names
 *
 * @constructor Creates cards
 *
 * @example {{{
 *          val factoryCard = new CardFactory()
 *          val card = factoryCard("Elemento")
 *          }}}
 *
 * @see Card
 *      CFactory
 *
 * @author Scarlett Plaza
 * @since 1.0
 * @version 1.0
 */
class CardFactory extends CFactory {
  val refMorADistancia = new AplicaHabilidad("refuerzo moral ADistancia", new RefuerzoMoralADistancia(1))
  val VinEstADistancia = new AplicaHabilidad("Vinculo estrecho ADistancia", new VinculoEstrechoADistancia())
  val NullADistancia = new AplicaHabilidad("refuerzo moral ADistancia", new NullHabilidad())
  val ataquesADistancia: List[AplicaHabilidad] = List(refMorADistancia, VinEstADistancia, NullADistancia)

  val refMorAsedio = new AplicaHabilidad("refuerzo moral asedio", new RefuerzoMoralAsedio(1))
  val VinEstAsedio = new AplicaHabilidad("Vinculo estrecho asedio", new VinculoEstrechoAsedio())
  val NullAsedio = new AplicaHabilidad("refuerzo moral asedio", new NullHabilidad())
  val ataquesAsedio: List[AplicaHabilidad] = List(refMorAsedio, VinEstAsedio, NullAsedio)

  val refMorCuerpoACuerpo = new AplicaHabilidad("refuerzo moral CuerpoACuerpo", new RefuerzoMoralCuerpoACuerpo(1))
  val VinEstCuerpoACuerpo = new AplicaHabilidad("Vinculo estrecho CuerpoACuerpo", new VinculoEstrechoCuerpoACuerpo())
  val NullCuerpoACuerpo = new AplicaHabilidad("refuerzo moral CuerpoACuerpo", new NullHabilidad())
  val ataquesCuerpoACuerpo: List[AplicaHabilidad] = List(refMorCuerpoACuerpo, VinEstCuerpoACuerpo, NullCuerpoACuerpo)

  val lluviaTorrencial = new AplicaHabilidad("lluviaTorrencial", new LluviaTorrencial())
  val nieblaImpenetrable = new AplicaHabilidad("nieblaImpenetrable", new NieblaImpenetrable())
  val escarchaMordiente = new AplicaHabilidad("escarchaMordiente", new EscarchaMordiente())
  val climaDespejado = new AplicaHabilidad("climaDespejado", new ClimaDespejado())
  val ataquesWeather: List[AplicaHabilidad] = List(lluviaTorrencial, nieblaImpenetrable, escarchaMordiente, climaDespejado)

  val namesADistancia: List[String] = List("Elemento", "Chaucha", "Yo no fui", "Neumatex", "Maletin", "Jefe", "Yo soy", "Ro", "Duquesa")
  val cardsADistancia: List[ADistanciaCard] = List.tabulate(namesADistancia.length)(i => new ADistanciaCard(namesADistancia(i), 1, List(ataquesADistancia(i % 3))))
  val namesAsedio: List[String] = List("Copi copi", "Mente en blanco", "Tepo tepo", "Palmerita", "Etcetera", "Rucia", "Guason", "Chu", "James Bond")
  val cardsAsedio: List[AsedioCard] = List.tabulate(namesAsedio.length)(i => new AsedioCard(namesAsedio(i), 1, List(ataquesAsedio(i % 3))))
  val namesCuerpoACuerpo: List[String] = List("Adjetivo", "Coliforme", "Fierro malo", "Cortachurro", "Choapino", "Rata", "Cucky", "Neumatico", "Chamullo")
  val cardsCuerpoACuerpo: List[CuerpoACuerpoCard] = List.tabulate(namesCuerpoACuerpo.length)(i => new CuerpoACuerpoCard(namesCuerpoACuerpo(i), 1, List(ataquesCuerpoACuerpo(i % 3))))
  val namesWeather: List[String] = List("Pescado", "Moneda", "Lili", "Calugoso", "Pelusa", "Amigo", "Calendario")
  val cardsWeather: List[WeatherCard] = List.tabulate(namesWeather.length)(i => new WeatherCard(namesWeather(i), List(ataquesWeather(i % 4))))

  val cardsCards: List[Card] = List.concat(cardsADistancia, cardsAsedio, cardsCuerpoACuerpo, cardsWeather)
  /**
   * Creates a card with the specified name.
   *
   * @param name The name of the card to be created.
   * @return The created card.
   * @throws Exception if the card does not exist.
   *
   * @author Scarlett Plaza
   * @since 1.0
   * @version 1.0
   */
  override def apply[T<:Card](name: String): T= {
    var cardOption: Option[Card] = cardsCards.find(_.name == name)
    cardOption match {
      case Some(card) => card.asInstanceOf[T]
      case None => throw new Exception("No existe la carta")
    }
  }
}
