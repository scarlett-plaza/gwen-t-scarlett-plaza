package cl.uchile.dcc
package gwent

import scala.collection.mutable.ListBuffer
import scala.util.Random

//trait tDeckFactory{
//  def random_card():Card
//  def random_deck():ListBuffer[Card]
//}

/** A class in charge of creating cards, random cards and random decks
 * The cards are named after Mario Hugo's dogs form the show 31 minutos
 */
abstract class DeckFactory() {
  private val random = new Random()
  val unitcards_available = Map("Copi copi"->"Asedio", "Elemento"->"Cuerpo a cuerpo" , "Adjetivo"->"Combate a distancia",
                                "Mente en blanco"->"Asedio", "Chaucha"->"Cuerpo a cuerpo",
                                "Coliforme"->"Combate a distancia", "Tepo tepo"->"Asedio", "Yo no fui"->"Cuerpo a cuerpo",
                                "Fierro malo"->"Combate a distancia", "Palmerita"->"Asedio", "Neumatex"->"Cuerpo a cuerpo",
                                "Cortachurro"->"Combate a distancia", "Etcetera"->"Asedio", "Maletin"->"Cuerpo a cuerpo",
                                "Choapino"->"Combate a distancia", "Rucia"->"Asedio", "Jefe"->"Cuerpo a cuerpo",
                                "Rata"->"Combate a distancia")
  val avilityunitcards_available = Map("Guason" -> "Asedio", "Yo soy" -> "Cuerpo a cuerpo",
                                        "Cucky" -> "Combate a distancia", "Chu" -> "Asedio", "Ro" -> "Cuerpo a cuerpo",
                                        "Neumatico" -> "Combate a distancia", "James Bond" -> "Asedio",
                                        "Senhor" -> "Cuerpo a cuerpo", "Chamullo" -> "Combate a distancia",
                                        "Duquesa" -> "Asedio")
  val wheathercards_available = Map("Pescado" -> "Asedio", "Moneda"-> "Cuerpo a cuerpo", "Lili"-> "Cuerpo a cuerpo",
                                    "Calugoso"-> "Asedio", "Pelusa"-> "Cuerpo a cuerpo", "Amigo"-> "Cuerpo a cuerpo",
                                    "Calendario"-> "Asedio")
  val complete_unitcard = unitcards_available ++ avilityunitcards_available
  val cards_available = complete_unitcard ++ wheathercards_available

  private val key_list = cards_available.keys.toList

  /** Creates a card given a number and a map of the names and zone
   * Before it runs, it ensures that the given number is in the boundary of quantity of cards you can choose from
   * @param numero The number that indicates the position from the map of the card you are creating
   * @param cards The map of existing cards
   * @return Card with the name and zone of the map of existing cards
   *
   * @example
   * val card = create_card(2)
   * println("name: " + card.name + ", zone: " + card.zone)
   */

  def create_card(numero: Int, cards: Map[String, String] = cards_available): Card = {
    assert(numero<key_list.length)
    val name = key_list(numero)
    val zone = cards_available(name)
    return new Card(name, zone)
  }

  /** Creates a random card from the posible cards
   *  Calculates a random number and then it creates a card with it
   *
   * @return a random card
   * @example
   * val random_card = random_card()
   * println("name: " + card.name + ", zone: " + card.zone)
   */

  def random_card(): Card = {
    val random_number = random.nextInt(key_list.length)
    val arandom_card = create_card(random_number)
    arandom_card
  }

  /** Creates a random deck of cards
   * By defect the deck has 25 cards but it can be changed
   * @param quantity Amount of cards in the deck
   * @return a Listbuffer of random cards
   *
   * @example
   * val random_deck = random_deck()
   * random_deck.foreach(card => println(s"Name: ${card.name}, Zone: ${card.zone}"))
   */
  def random_deck(quantity: Int=25): ListBuffer[Card] = {
    val arandom_deck = ListBuffer.fill(quantity)(random_card())
    return arandom_deck
  }
}
