package de.life.hacked.persistence.models

import java.util.*


data class Location(
  val id: UUID,
  var street: String,
  var number: String,
  var city: String,
  var zip: String,
  var country: String,
  var type: Type,
) {


  companion object {
    enum class Type {

      OFFICE,
      BAR,
      DOCTOR,

      // TODO
      STORE,
      OTHER,
    }
  }
}