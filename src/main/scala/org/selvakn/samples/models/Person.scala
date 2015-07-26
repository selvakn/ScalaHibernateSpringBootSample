package org.selvakn.samples.models

import javax.persistence.{Entity, Table}

import org.selvakn.NoArgsConstructor


@Entity
@Table(name = "persons")
@NoArgsConstructor
case class Person(firstName: String, lastName: String) extends BaseModel