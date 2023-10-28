package de.life.hacked.persistence.models

import java.util.*

data class BankRecipient(
  val id: UUID,
) {

}

data class Company(
  val id: UUID,
  var name: String,
  var locations: Map<Location.Companion.Type, Location>?,
  var bankAccount: BankRecipient?,
) {

}
