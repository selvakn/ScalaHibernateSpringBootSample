package org.selvakn.samples.models

import javax.persistence._


@Entity
@Table(name = "persons")
case class Person(firstName: String, lastName: String) extends BaseModel[Person] {

  def this() = this(null, null)

  def updateName(newName: String) = {
    this.copy(firstName = newName)
  }
}

