package org.selvakn.samples.service

import org.selvakn.samples.models.Person
import org.springframework.data.repository.CrudRepository

trait PersonRepository extends CrudRepository[Person, java.lang.Long] {
}
