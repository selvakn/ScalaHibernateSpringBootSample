package org.selvakn.samples

import org.springframework.context.{ApplicationContext, ApplicationContextAware}
import org.springframework.stereotype.Component

object ApplicationContextProvider {
  private var context: ApplicationContext = null

  def getBean[T: Manifest](implicit m: Manifest[T]): T = context.getBean(m.runtimeClass.asInstanceOf[Class[T]])
}

@Component
class ApplicationContextProvider extends ApplicationContextAware {
  def getApplicationContext: ApplicationContext = ApplicationContextProvider.context

  def setApplicationContext(ac: ApplicationContext) {
    ApplicationContextProvider.context = ac
  }
}