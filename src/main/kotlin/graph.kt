package demo

import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component

data class Person(val craft: String, val name: String, var personImageUrl: String? = "", var personBio: String? = "")

@Component
class RootQuery : Query {
  private var peopleInSpaceApi = PeopleInSpaceApi()

  suspend fun people(): List<Person> {
    return peopleInSpaceApi.fetchPeople().people.map {
      Person(it.craft, it.name, it.personImageUrl, it.personBio)
    }
  }
}
