package com.github.seratch.scalikesolr.request

import org.scalatest._
import org.scalatest.matchers._
import common.WriterType
import com.github.seratch.scalikesolr._

class AddRequestSpec extends FlatSpec with ShouldMatchers {

  behavior of "AddRequest"

  it should "be available" in {
    val core: SolrCore = null
    val documents: List[SolrDocument] = Nil
    val writerType: WriterType = null
    val additionalQueryString: String = ""
    val instance = new AddRequest(core, documents, writerType, additionalQueryString)
    instance should not be null
  }

}
