package org.selvakn.samples.service

import javax.persistence.{EntityManager, EntityManagerFactory}

import org.junit.runner.RunWith
import org.scalatest.{BeforeAndAfterEach, FunSpec}
import org.scalatest.junit.JUnitRunner
import org.selvakn.samples.{ApplicationContextProvider, Config}
import org.selvakn.samples.models.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.context.ApplicationContext
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.test.context.{ContextConfiguration, TestContextManager}
import org.springframework.transaction.{TransactionStatus, TransactionDefinition}
import org.springframework.transaction.support.DefaultTransactionDefinition

import scala.collection.JavaConverters._


class PersonRepositoryTest extends BaseRepositoryTest {

  @Autowired
  var personRepository: PersonRepository = _

  def fixture =
    new {
      val person = new Person("Foo", "Bar")
    }


  describe("PersonRepository") {
    it("should be able to load all persons") {

      personRepository.save(fixture.person)

      val persons = personRepository.findAll().asScala
      assert(persons.size === 1)
      assert(persons.head.firstName === "Foo")
      assert(persons.head.lastName === "Bar")
    }

    it("should be able to update a person value") {
      val person: Person = fixture.person
      personRepository.save(person)

      val modifiedPerson: Person = person.updateName("Baz")
      personRepository.save(modifiedPerson)

      val modifiedPersonsList = personRepository.findAll().asScala

      assert(modifiedPersonsList.size === 1)
      assert(modifiedPersonsList.head.id === person.id)
      assert(modifiedPersonsList.head.firstName === "Baz")
      assert(modifiedPersonsList.head.lastName === "Bar")
    }
  }
}
