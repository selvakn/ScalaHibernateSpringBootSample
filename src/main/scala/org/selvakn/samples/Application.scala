package org.selvakn.samples

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Config

object Application extends App {
  SpringApplication.run(classOf[Config])
}