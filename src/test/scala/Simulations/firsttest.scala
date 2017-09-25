package simulations

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class firsttest extends Simulation {

	val httpProtocol = http
		.baseURL("http://computer-database.gatling.io")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png"""), WhiteList())
		.acceptHeader("*/*")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.5")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:55.0) Gecko/20100101 Firefox/55.0")

	val headers_0 = Map("Pragma" -> "no-cache")

	val headers_4 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"Upgrade-Insecure-Requests" -> "1")

    val uri2 = "http://detectportal.firefox.com/success.txt"

	val scn = scenario("firsttest")
		.exec(http("request_0")
			.get(uri2 + "")
			.headers(headers_0)
			.resources(http("request_1")
			.get(uri2 + "")
			.headers(headers_0)))
		.pause(4)
		.exec(http("request_2")
			.get(uri2 + "")
			.headers(headers_0))
		.pause(54)
		.exec(http("request_3")
			.get(uri2 + "")
			.headers(headers_0))
		.pause(34)
		.exec(http("request_4")
			.get("/")
			.headers(headers_4))
		.pause(8)
		.exec(http("request_5")
			.get("/computers/381")
			.headers(headers_4))
		.pause(4)
		.exec(http("request_6")
			.get("/computers")
			.headers(headers_4))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}