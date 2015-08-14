package org.selvakn.samples.service

import org.selvakn.samples.models.{BaseModel, Person}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.{Repository, Component}

import scala.beans.BeanProperty

trait PersonRepository extends CrudRepository[Person, java.lang.Long] {
}
