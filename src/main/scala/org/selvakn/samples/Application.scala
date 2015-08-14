package org.selvakn.samples

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
class Config

@EnableJpaRepositories(Array("org.selvakn.examples"))
object Application extends App {
  SpringApplication.run(classOf[Config])
}