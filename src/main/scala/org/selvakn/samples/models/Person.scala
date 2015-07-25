package org.selvakn.samples.models

import javax.persistence.{Entity, Table}

@Entity
@Table(name = "persons")
case class Person(firstName: String, lastName: String) extends BaseModel {
  def this() = this(null, null)
}