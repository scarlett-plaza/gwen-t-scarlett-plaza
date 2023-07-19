package cl.uchile.dcc
package gwent.board

import cl.uchile.dcc.gwent.cards.{ADistanciaCard, AsedioCard, Card, CardFactory, CuerpoACuerpoCard, WeatherCard}
import cl.uchile.dcc.gwent.habilidad.{AplicaHabilidad, ClimaDespejado, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable, NullHabilidad, RefuerzoMoralADistancia, RefuerzoMoralAsedio, RefuerzoMoralCuerpoACuerpo, VinculoEstrechoADistancia, VinculoEstrechoAsedio, VinculoEstrechoCuerpoACuerpo}
import cl.uchile.dcc.gwent.player.{Player, PlayerFactory}
import munit.FunSuite

import scala.collection.immutable.Nil.foreach
import scala.collection.mutable.ListBuffer
import scala.util.Random

class boardTest extends FunSuite{

  val namesADistancia: List[String] = List("Elemento", "Chaucha", "Yo no fui", "Neumatex", "Maletin", "Jefe", "Yo soy", "Ro", "Duquesa")
  val namesAsedio: List[String] = List("Copi copi", "Mente en blanco", "Tepo tepo", "Palmerita", "Etcetera", "Rucia", "Guason", "Chu", "James Bond")
  val namesCuerpoACuerpo: List[String] = List("Adjetivo", "Coliforme", "Fierro malo", "Cortachurro", "Choapino", "Rata", "Cucky", "Neumatico", "Chamullo")
  val namesWeather: List[String] = List("Pescado", "Moneda", "Lili", "Calugoso", "Pelusa", "Amigo", "Calendario")

  val cardFactory = new CardFactory()
  val ADistanciaCard: List[ADistanciaCard] = namesADistancia.map(cardFactory.apply[ADistanciaCard])
  val AsedioCard: List[AsedioCard] = namesAsedio.map(cardFactory.apply[AsedioCard])
  val CuerpoACuerpoCard: List[CuerpoACuerpoCard] = namesCuerpoACuerpo.map(cardFactory.apply[CuerpoACuerpoCard])
  val WeatherCard: List[WeatherCard] = namesWeather.map(cardFactory.apply[WeatherCard])

  val nombre1 = "Juan Carlos Bodoque"
  val nombre2 = "Juanin Juan Harry"
  val nombre3 = "Mario Hugo"
  val deckQuantity = 25
  val handQuantity = 10

  val playerFactory = new PlayerFactory()

  val inicializador = new Inicializador()
  val deckADistancia = inicializador.createDeck(ADistanciaCard, deckQuantity)
  val deckAsedio = inicializador.createDeck(AsedioCard, deckQuantity)
  val deckCuerpoACuerpo = inicializador.createDeck(CuerpoACuerpoCard, deckQuantity)
  val deckWeather = inicializador.createDeck(WeatherCard, deckQuantity)
  val handADistancia = inicializador.createHand(deckADistancia, handQuantity)
  val handAsedio = inicializador.createHand(deckAsedio, handQuantity)
  val handCuerpoACuerpo = inicializador.createHand(deckCuerpoACuerpo, handQuantity)
  val handWeather = inicializador.createHand(deckWeather, handQuantity)

  val jugador1 = playerFactory(nombre1, 25, 10, 2)
  val jugador2 = playerFactory(nombre2, 25, 10, 2)
  val jugador3 = playerFactory(nombre3, 25, 10, 2)
  val jugadorADistancia = new Player(nombre1, 2, deckADistancia, handADistancia)
  val jugadorAsedio = new Player(nombre2, 2, deckAsedio, handAsedio)
  val jugadorCuerpoACuerpo = new Player(nombre3, 2, deckCuerpoACuerpo, handCuerpoACuerpo)
  val jugadorWeather = new Player(nombre1, 2, deckWeather, handWeather)

  val board1 = new Board(List(jugador1, jugador2, jugador3))
  val board2 = new Board(List(jugador1, jugador2, jugador3))
  val board3 = new Board(List(jugador1, jugador2))
  val board4 = new Board(List(jugador1, jugador2, jugador3))
  val boardSeparados = new Board(List(jugadorADistancia, jugadorAsedio, jugadorCuerpoACuerpo, jugadorWeather))
  board4.playCard(jugador1.hand.head, jugador1)

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
    assert(!board1.equals(jugador1.hand.head))
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
