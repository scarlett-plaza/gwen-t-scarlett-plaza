package cl.uchile.dcc
package gwent.board

import cl.uchile.dcc.gwent.cards.{ADistanciaCard, AsedioCard, Card, CuerpoACuerpoCard, WeatherCard}
import cl.uchile.dcc.gwent.habilidad.{AplicaHabilidad, ClimaDespejado, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable, NullHabilidad, RefuerzoMoralADistancia, RefuerzoMoralAsedio, RefuerzoMoralCuerpoACuerpo, VinculoEstrechoADistancia, VinculoEstrechoAsedio, VinculoEstrechoCuerpoACuerpo}
import cl.uchile.dcc.gwent.player.Player
import munit.FunSuite

import scala.collection.mutable.ListBuffer
import scala.util.Random

class boardTest extends FunSuite{
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
  val random = new Random()
  val cardsADistancia: List[ADistanciaCard] = List.tabulate(namesADistancia.length)(i => new ADistanciaCard(namesADistancia(i), 1, List(ataquesADistancia(i%3))))
  val namesAsedio: List[String] = List("Copi copi", "Mente en blanco", "Tepo tepo", "Palmerita", "Etcetera", "Rucia", "Guason", "Chu", "James Bond")
  val cardsAsedio: List[AsedioCard] = List.tabulate(namesAsedio.length)(i => new AsedioCard(namesAsedio(i), 1, List(ataquesAsedio(i%3))))
  val namesCuerpoACuerpo: List[String] = List("Adjetivo", "Coliforme", "Fierro malo", "Cortachurro", "Choapino", "Rata", "Cucky", "Neumatico", "Chamullo")
  val cardsCuerpoACuerpo: List[CuerpoACuerpoCard] = List.tabulate(namesCuerpoACuerpo.length)(i => new CuerpoACuerpoCard(namesCuerpoACuerpo(i), 1, List(ataquesCuerpoACuerpo(i%3))))
  val namesWeather: List[String] = List("Pescado", "Moneda", "Lili", "Calugoso", "Pelusa", "Amigo", "Calendario")
  val cardsWeather: List[WeatherCard] = List.tabulate(namesWeather.length)(i => new WeatherCard(namesWeather(i), List(ataquesWeather(i%4)) ))

  val cardsCards: List[Card] = List.concat(cardsADistancia, cardsAsedio, cardsCuerpoACuerpo, cardsWeather)

  val nombre1 = "Juan Carlos Bodoque"
  val nombre2 = "Juanin Juan Harry"
  val nombre3 = "Mario Hugo"
  val deckQuantity = 25
  val handQuantity = 10

  val iniciador = new Inicializador()

  val deck1: ListBuffer[Card] = iniciador.createDeck(cardsCards, deckQuantity)
  val hand1: ListBuffer[Card] = iniciador.createHand(deck1, handQuantity)
  val deck2: ListBuffer[Card] = iniciador.createDeck(cardsCards, deckQuantity)
  val hand2: ListBuffer[Card] = iniciador.createHand(deck2, handQuantity)
  val deck3: ListBuffer[Card] = iniciador.createDeck(cardsCards, deckQuantity)
  val hand3: ListBuffer[Card] = iniciador.createHand(deck3, handQuantity)
  val deckADistancia: ListBuffer[Card] = iniciador.createDeck(cardsADistancia, deckQuantity)
  val handADistancia: ListBuffer[Card] = iniciador.createHand(deckADistancia, handQuantity)
  val deckAsedio: ListBuffer[Card] = iniciador.createDeck(cardsAsedio, deckQuantity)
  val handAsedio: ListBuffer[Card] = iniciador.createHand(deckAsedio, handQuantity)
  val deckCuerpoACuerpo: ListBuffer[Card] = iniciador.createDeck(cardsCuerpoACuerpo, deckQuantity)
  val handCuerpoACuerpo: ListBuffer[Card] = iniciador.createHand(deckCuerpoACuerpo, handQuantity)
  val deckWeather: ListBuffer[Card] = iniciador.createDeck(cardsWeather, deckQuantity)
  val handWeather: ListBuffer[Card] = iniciador.createHand(deckWeather, handQuantity)

  val jugador1 = new Player(nombre1, 2, deck1, hand1)
  val jugador2 = new Player(nombre2, 2, deck2, hand2)
  val jugador3 = new Player(nombre3, 2, deck3, hand3)
  val jugadorADistancia = new Player(nombre1, 2, deckADistancia, handADistancia)
  val jugadorAsedio = new Player(nombre2, 2, deckAsedio, handAsedio)
  val jugadorCuerpoACuerpo = new Player(nombre3, 2, deckCuerpoACuerpo, handCuerpoACuerpo)
  val jugadorWeather = new Player(nombre1, 2, deckWeather, handWeather)

  val board1 = new Board(List(jugador1, jugador2, jugador3))
  val board2 = new Board(List(jugador1, jugador2, jugador3))
  val board3 = new Board(List(jugador1, jugador2))
  val board4 = new Board(List(jugador1, jugador2, jugador3))
  val boardSeparados = new Board(List(jugadorADistancia, jugadorAsedio, jugadorCuerpoACuerpo, jugadorWeather))
  board4.playCard(hand1.head, jugador1)

  test("Dos tableros iguales son iguales"){
    assert(board1.equals(board2))
    assert(!board1.equals(board3))
    assert(!board1.equals(board4))
  }

  test("Dos tableros iguales tienen el mismo hash"){
    assert(board1.hashCode() == board2.hashCode())
    assert(board1.hashCode() != board3.hashCode())
    assert(board1.hashCode() != board4.hashCode())
  }

  test("un tablero no es una carta, o jugador"){
    assert(!board1.equals(hand1.head))
    val jugadorADistanciaHandHead = jugadorADistancia.hand.head
    val jugadorAsedioHandHead = jugadorAsedio.hand.head
    val jugadorCuerpoACuerpoHandHead = jugadorCuerpoACuerpo.hand.head
    val jugadorWeatherHandHead = jugadorWeather.hand.head
    boardSeparados.playCard(jugadorADistanciaHandHead, jugadorADistancia)
    boardSeparados.playCard(jugadorAsedioHandHead, jugadorAsedio)
    boardSeparados.playCard(jugadorCuerpoACuerpoHandHead, jugadorCuerpoACuerpo)
    boardSeparados.playCard(jugadorWeatherHandHead, jugadorWeather)
    boardSeparados.boardSection.get(jugadorADistancia) match {
      case Some(aDistancia, asedio, cuerpoACuerpo) =>
        assert(!aDistancia.equals(jugadorADistanciaHandHead))
        assert(!asedio.equals(jugadorADistanciaHandHead))
        assert(!cuerpoACuerpo.equals(jugadorADistanciaHandHead))
        assert(!boardSeparados.weatherSection.equals(jugadorCuerpoACuerpoHandHead))
      case None => assert(false)
    }
  }


  test("Cuando agrego una carta a una sección se agrega a esa sección"){
    val jugadorADistanciaHandHead = jugadorADistancia.hand.head
    val jugadorAsedioHandHead = jugadorAsedio.hand.head
    val jugadorCuerpoACuerpoHandHead = jugadorCuerpoACuerpo.hand.head
    val jugadorWeatherHandHead = jugadorWeather.hand.head
    boardSeparados.playCard(jugadorADistanciaHandHead, jugadorADistancia)
    boardSeparados.playCard(jugadorAsedioHandHead, jugadorAsedio)
    boardSeparados.playCard(jugadorCuerpoACuerpoHandHead, jugadorCuerpoACuerpo)
    boardSeparados.playCard(jugadorWeatherHandHead, jugadorWeather)
    boardSeparados.boardSection.get(jugadorADistancia) match {
      case Some(aDistancia, asedio, cuerpoACuerpo) =>
        assert(aDistancia.section.contains(jugadorADistanciaHandHead))
        assert(!asedio.section.contains(jugadorADistanciaHandHead))
        assert(!cuerpoACuerpo.section.contains(jugadorADistanciaHandHead))
        assert(!boardSeparados.weatherSection.section.contains(jugadorCuerpoACuerpoHandHead))
      case None => assert(false)
    }
    boardSeparados.boardSection.get(jugadorAsedio) match {
      case Some(aDistancia, asedio, cuerpoACuerpo) =>
        assert(!aDistancia.section.contains(jugadorAsedioHandHead))
        assert(asedio.section.contains(jugadorAsedioHandHead))
        assert(!cuerpoACuerpo.section.contains(jugadorAsedioHandHead))
        assert(!boardSeparados.weatherSection.section.contains(jugadorAsedioHandHead))
      case None => assert(false)
    }
    boardSeparados.boardSection.get(jugadorCuerpoACuerpo) match {
      case Some(aDistancia, asedio, cuerpoACuerpo) =>
        assert(!aDistancia.section.contains(jugadorCuerpoACuerpoHandHead))
        assert(!asedio.section.contains(jugadorCuerpoACuerpoHandHead))
        assert(cuerpoACuerpo.section.contains(jugadorCuerpoACuerpoHandHead))
        assert(!boardSeparados.weatherSection.section.contains(jugadorCuerpoACuerpoHandHead))
      case None => assert(false)
    }
    boardSeparados.boardSection.get(jugadorWeather) match {
      case Some(aDistancia, asedio, cuerpoACuerpo) =>
        assert(!aDistancia.section.contains(jugadorWeatherHandHead))
        assert(!asedio.section.contains(jugadorWeatherHandHead))
        assert(!cuerpoACuerpo.section.contains(jugadorWeatherHandHead))
        assert(boardSeparados.weatherSection.section.contains(jugadorWeatherHandHead))
      case None => assert(false)
    }
  }
}
