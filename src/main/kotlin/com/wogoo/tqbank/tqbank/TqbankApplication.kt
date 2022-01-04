package com.wogoo.tqbank.tqbank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class TqbankApplication

fun main(args: Array<String>) {
	runApplication<TqbankApplication>(*args)
}
