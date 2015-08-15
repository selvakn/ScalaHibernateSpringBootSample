package org.selvakn.samples.service

import javax.persistence.EntityManagerFactory

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{BeforeAndAfterEach, FunSpec}
import org.selvakn.samples.{ApplicationContextProvider, Config}
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.test.context.{ContextConfiguration, TestContextManager}
import org.springframework.transaction.support.DefaultTransactionDefinition
import org.springframework.transaction.{TransactionDefinition, TransactionStatus}

@RunWith(classOf[JUnitRunner])
@ContextConfiguration(loader = classOf[SpringApplicationContextLoader], classes = Array(classOf[Config]))
class BaseRepositoryTest extends FunSpec with BeforeAndAfterEach {

  var transactionManager: JpaTransactionManager = _
  var transactionStatus: TransactionStatus = _

  new TestContextManager(this.getClass).prepareTestInstance(this)

  override def beforeEach() {
    val definition = new DefaultTransactionDefinition() {
      setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED)
    }
    val entityManagerFactory = ApplicationContextProvider.getBean[EntityManagerFactory]
    transactionManager = new JpaTransactionManager(entityManagerFactory)
    transactionStatus = transactionManager.getTransaction(definition)
  }

  override def afterEach() {
    transactionManager.rollback(transactionStatus)
  }


}
