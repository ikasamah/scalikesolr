package com.github.seratch.scalikesolr.util

import org.scalatest._
import org.scalatest.matchers._
import org.slf4j.{ LoggerFactory, Logger }

class LogSpec extends FlatSpec with ShouldMatchers {

  behavior of "Log"

  it should "be available" in {
    val logger: Logger = LoggerFactory.getLogger("foo")
    val log = new Log(logger)
    log should not be null
  }

}
