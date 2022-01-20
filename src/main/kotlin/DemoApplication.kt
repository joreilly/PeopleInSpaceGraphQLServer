package demo

import kotlinx.coroutines.delay
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DefaultApplication {
}

fun main(args: Array<String>) {
    runApplication<DefaultApplication>(*args)
}
