package demo

import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component


data class People(val people: List<Assignment>)

@Component
class RootQuery : Query {
  private var peopleInSpaceApi = PeopleInSpaceApi()

  suspend fun people() = peopleInSpaceApi.fetchPeople().people
}
