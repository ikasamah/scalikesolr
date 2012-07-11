package com.github.seratch.scalikesolr.request.query

import org.scalatest._
import org.scalatest.matchers._

class FieldsToReturnSpec extends FlatSpec with ShouldMatchers {

  behavior of "FieldsToReturn"

  it should "be available" in {
    val fl: String = ""
    val instance = new FieldsToReturn(fl)
    instance should not be null
    instance.getKey() should equal("fl")
  }

}
