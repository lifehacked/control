package de.life.hacked.persistence.models

import java.util.*


data class Amount(
  val id: UUID,
  var value: Int,
  var currency: Currency,
) {

}