package demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DefaultApplication {
}

fun main(args: Array<String>) {
    runApplication<DefaultApplication>(*args)
}
