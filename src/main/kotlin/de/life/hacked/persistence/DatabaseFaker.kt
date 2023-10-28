package de.life.hacked.persistence

import de.life.hacked.persistence.models.Event
import kotlin.collections.ArrayList

private const val TERMIN = "termin"

class DatabaseFaker {
  private val data = mapOf(
    TERMIN to ArrayList<Event>(),

  )

}