package cl.uchile.dcc
package gwent.cards

import gwent.habilidad.NullHabilidad

trait CFactory {
  def apply[T <: Card](name: String): T
}