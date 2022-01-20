package demo

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.engine.java.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json


@Serializable
data class AstroResult(val message: String, val number: Int, val people: List<Assignment>)

@Serializable
data class IssResponse(val message: String, val iss_position: IssPosition, val timestamp: Long)


class PeopleInSpaceApi(
    var baseUrl: String = "https://people-in-space-proxy.ew.r.appspot.com",
) {
    val client = createHttpClient()

    suspend fun fetchPeople() = client.get("$baseUrl/astros.json").body<AstroResult>()
    suspend fun fetchISSPosition() = client.get("$baseUrl/iss-now.json").body<IssResponse>()
}

fun createHttpClient() = HttpClient(Java) {
    val json = Json { isLenient = true; ignoreUnknownKeys = true }
    install(ContentNegotiation) {
        json(json)
    }
    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.INFO
    }
}