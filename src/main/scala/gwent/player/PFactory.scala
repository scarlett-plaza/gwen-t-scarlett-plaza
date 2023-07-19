package cl.uchile.dcc
package gwent.player

trait PFactory {
  def apply(name: String, deckQuantity: Int, handQuantity: Int, gems: Int): Player
}
