package cl.uchile.dcc
package gwent.habilidad

import gwent.cards.Card

class NullHabilidad() extends Habilidad{
  override def apply(self:Card, target: Card): Unit = {}
}
