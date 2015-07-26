package org.selvakn.samples.models

import javax.persistence.{MappedSuperclass, Id}

import scala.beans.BeanProperty

@MappedSuperclass
trait BaseModel {
  @Id
  @BeanProperty
  var id: Long = _
}
