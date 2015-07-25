package org.selvakn.samples.models

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "persons")
case class Person(firstName: String, lastName: String) {
  @Id
  var id: Long = _

  def this() = this(null, null)
}