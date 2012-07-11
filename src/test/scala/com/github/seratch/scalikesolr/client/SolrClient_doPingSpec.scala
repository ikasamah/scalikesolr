package com.github.seratch.scalikesolr.client

import java.net.URL
import com.github.seratch.scalikesolr.Solr
import org.slf4j.LoggerFactory
import com.github.seratch.scalikesolr.request.PingRequest
import com.github.seratch.scalikesolr.request.common.WriterType
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class SolrClient_doPingSpec extends FlatSpec with ShouldMatchers {

  behavior of "SolrClient#doPing"

  val log = LoggerFactory.getLogger("com.github.seratch.scalikesolr.SolrClientSpec")
  val client = Solr.httpServer(new URL("http://localhost:8983/solr")).newClient()

  it should "be available" in {
    val request = new PingRequest()
    val response = client.doPing(request)

    response should not be null
    response.status should equal("OK")
    response.responseHeader.status should equal(0)
    response.responseHeader.qTime should be > 0
    response.rawBody.replaceAll("\r", "").replaceAll("\n", "").trim should fullyMatch regex """<\?xml version="1.0" encoding="UTF-8"\?>
                                               |<response>
                                               |<lst name="responseHeader"><int name="status">0</int><int name="QTime">\d+</int><lst name="params"><str name="echoParams">all</str><str name="rows">10</str><str name="echoParams">all</str><str name="wt">standard</str><str name="q">solrpingquery</str><str name="qt">search</str></lst></lst><str name="status">OK</str>
                                               |</response>
                                               | """.stripMargin.replaceAll("\r", "").replaceAll("\n", "").trim
  }

  it should "be available with JSON format" in {
    val request = new PingRequest(writerType = WriterType.JSON)
    val response = client.doPing(request)

    response should not be null
    response.status should equal("OK")
    response.responseHeader.status should equal(0)
    response.responseHeader.qTime should be > 0
    response.rawBody.replaceAll("\\s+", "") should fullyMatch regex """\{"responseHeader":
      \{"status":0,"QTime":\d+,"params":
        \{"echoParams":"all","rows":"10","echoParams":"all","wt":"json","q":"solrpingquery","qt":"search"\}
      \},
      "status":"OK"
    \}""".replaceAll("\\s+", "")
  }

}