package org.selvakn.samples.service

import org.scalatest.FunSpec
import org.selvakn.samples.Config
import org.selvakn.samples.models.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.{ContextConfiguration, TestContextManager}

import scala.collection.JavaConverters._

@ContextConfiguration(loader = classOf[SpringApplicationContextLoader], classes = Array(classOf[Config]))
class PersonRepositoryTest extends FunSpec {

  @Autowired
  var personRepository: PersonRepository = _

  new TestContextManager(this.getClass()).prepareTestInstance(this)

  describe("PersonRepository#findAll") {
    it("should be able to load all persons") {
      val newPerson = Person("Foo", "Bar")
      personRepository.save(newPerson)

      val persons = personRepository.findAll().asScala
      assert(persons.size === 1)

      assert(persons.head.firstName === "Foo")
    }
  }
}
