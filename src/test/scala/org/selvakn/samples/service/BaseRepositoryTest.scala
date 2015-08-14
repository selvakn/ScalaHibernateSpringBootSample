package org.selvakn.samples.service

import javax.persistence.EntityManagerFactory

import org.junit.runner.RunWith
import org.scalatest.{BeforeAndAfterEach, FunSpec}
import org.scalatest.junit.JUnitRunner
import org.selvakn.samples.{ApplicationContextProvider, Config}
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.context.ApplicationContext
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.test.context.{TestContextManager, ContextConfiguration}
import org.springframework.transaction.{TransactionDefinition, TransactionStatus}
import org.springframework.transaction.support.DefaultTransactionDefinition

@RunWith(classOf[JUnitRunner])
@ContextConfiguration(loader = classOf[SpringApplicationContextLoader], classes = Array(classOf[Config]))
class BaseRepositoryTest extends FunSpec with BeforeAndAfterEach {

  var transactionManager: JpaTransactionManager = null
  var transactionStatus: TransactionStatus = null

  new TestContextManager(this.getClass()).prepareTestInstance(this)

  override def beforeEach() {
    val definition = new DefaultTransactionDefinition() {
      setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED)
    }
    val context: ApplicationContext = new ApplicationContextProvider().getApplicationContext
    transactionManager = new JpaTransactionManager(context.getBean(classOf[EntityManagerFactory]))
    transactionStatus = transactionManager.getTransaction(definition)
  }

  override def afterEach() {
    transactionManager.rollback(transactionStatus)
  }


}
