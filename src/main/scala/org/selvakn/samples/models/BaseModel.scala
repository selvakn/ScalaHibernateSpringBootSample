package org.selvakn.samples.models

import javax.persistence.{Id, MappedSuperclass, _}

import org.selvakn.samples.ApplicationContextProvider

import scala.beans.BeanProperty
import scala.reflect.ClassTag

@MappedSuperclass
abstract class BaseModel[A <: BaseModel[A]](implicit tag:ClassTag[A]) {
  @Id
  @BeanProperty
  var id: Long = _

  @Transient
  val entityManager = new ApplicationContextProvider().getApplicationContext.getBean(classOf[EntityManager])

  @Transient
  val entity = entityManager.find(tag.runtimeClass, id)

  if (entity != null) {
    entityManager.remove(entity)
  }
}



