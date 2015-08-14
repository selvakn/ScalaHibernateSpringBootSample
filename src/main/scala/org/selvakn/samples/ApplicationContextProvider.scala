package org.selvakn.samples

import org.springframework.beans.BeansException
import org.springframework.context.{ApplicationContext, ApplicationContextAware}
import org.springframework.stereotype.Component

@Component object ApplicationContextProvider {
  private var context: ApplicationContext = null
}

@Component class ApplicationContextProvider extends ApplicationContextAware {
  def getApplicationContext: ApplicationContext = {
    ApplicationContextProvider.context
  }

  @throws(classOf[BeansException])
  def setApplicationContext(ac: ApplicationContext) {
    ApplicationContextProvider.context = ac
  }
}