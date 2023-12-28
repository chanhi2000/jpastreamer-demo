package com.example.markiiimark

import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Test

import io.restassured.RestAssured.given
import org.hamcrest.Matchers.containsString

@QuarkusTest
class FilmResourceTest {

	@Test
	fun test() {
		given()
			.`when`().get("/film/5")
			.then()
			.statusCode(200)
			.body(containsString("AFRICAN EGG"))
	}
}