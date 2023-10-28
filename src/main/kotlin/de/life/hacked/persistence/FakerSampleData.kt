package de.life.hacked.persistence

import com.github.javafaker.Faker
import java.util.concurrent.TimeUnit.DAYS

fun getName(): String = Faker().hobbit().character()
fun getBank(): String = Faker().company().suffix()
fun getCompany(): String = Faker().company().name()
fun getAddress(): String = Faker().address().fullAddress()
fun getDate(maxFuture: Int): String = Faker().date().future(maxFuture, DAYS).toString()
fun getNumber(): String = Faker().number().digits(10)
fun getLorem(): String = Faker().lorem().paragraph()
fun getEmail(): String = Faker().internet().emailAddress()
fun getPhone(): String = Faker().phoneNumber().cellPhone()