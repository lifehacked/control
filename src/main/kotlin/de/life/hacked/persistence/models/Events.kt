package de.life.hacked.persistence.models

import java.util.*
import de.life.hacked.persistence.models.Event.Companion.Type as SuperType

interface EventType

abstract class Event {
  abstract val id: UUID
  abstract val superType: SuperType
  abstract var subType: EventType

  abstract var date: Date

  companion object {

    enum class Type : EventType {
      APPOINTMENT,
      PAYMENT,
      OTHER,
    }
  }
}

data class Appointment(
  override val id: UUID,
  override var subType: EventType,
  override var date: Date,
) : Event() {
  override val superType: SuperType
    get() = SuperType.APPOINTMENT

  companion object {
    enum class Type : EventType {
      MEETING,
      DOCTOR,
      OTHER,
    }
  }
}

data class Payment(
  override val id: UUID,
  override var subType: EventType,
  override var date: Date,
) : Event() {
  override val superType: SuperType
    get() = SuperType.PAYMENT

  companion object {
    enum class Type {
      INCOME,
      EXPENSE,
      OTHER,
    }
  }
}
