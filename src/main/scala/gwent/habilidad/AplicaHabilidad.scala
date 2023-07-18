package cl.uchile.dcc
package gwent.habilidad

import gwent.board.sections.Section
import gwent.cards.{Card}

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.player.Player

import java.util.Objects

class AplicaHabilidad(val name: String, val habilidad: Habilidad) extends Equals {

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[AplicaHabilidad]
  }
  
  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val otherCard = obj.asInstanceOf[AplicaHabilidad]
      (this eq otherCard) ||
        otherCard.name == name &&
          otherCard.habilidad == habilidad
    }
    else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(name, habilidad)
  }
  def apply(self: Card, target: Card): Unit = {
    habilidad.apply(self, target)
  }
}
