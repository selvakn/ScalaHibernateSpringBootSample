package org.selvakn.samples.service

import org.selvakn.samples.models.Person
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component

@Component
trait PersonRepository extends CrudRepository[Person, java.lang.Long]