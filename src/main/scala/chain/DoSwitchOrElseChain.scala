package chain

import baseConfig.BaseConfig
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object DoSwitchOrElseChain {

  private val CASE_GATLING = "https://gatling.io"
  private val CASE_SAUCE_LABS = "https://saucelabs.com/"
  private val CASE_LOAD_RUNNER = "https://www.microfocus.com"
  private val CASE_JMETER = "https://jmeter.apache.org/"

  private val PRODUCT_LOAD_RUNNER = "/es-es/products/loadrunner-load-testing/overview"
  private val JMETER_INDEX = "/index.html"
  private val SAUCE_LABS_SUPPORT = "/support"
  private val GATLING_DOCS_CURRENT = "/docs/current/"

  private val goLoadRunnerOverview = exec(http("GET " + PRODUCT_LOAD_RUNNER)
    .get(BaseConfig.baseUrl + PRODUCT_LOAD_RUNNER))

  private val goJmeterOverview = exec(http("GET " + JMETER_INDEX)
    .get(BaseConfig.baseUrl + JMETER_INDEX))

  private val goSauceLabOverview = exec(http("GET " + SAUCE_LABS_SUPPORT)
    .get(BaseConfig.baseUrl + SAUCE_LABS_SUPPORT))

  private val goGatlingCurrentDoc = exec(http("GET " + GATLING_DOCS_CURRENT)
    .get(BaseConfig.baseUrl + GATLING_DOCS_CURRENT))



  val switchOrElse = doSwitchOrElse(BaseConfig.baseUrl)(
    CASE_JMETER -> exec(goJmeterOverview),
    CASE_SAUCE_LABS ->exec(goSauceLabOverview),
    CASE_LOAD_RUNNER ->exec(goLoadRunnerOverview)
    )(
      exec(goGatlingCurrentDoc)
    )

}
