package de.life.hacked.persistence.models

import java.util.*


data class Date(
  val id: UUID,
  var date: Date,
  var locale: Locale,
) {

}