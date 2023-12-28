package com.example.markiiimark

import com.example.markiiimark.repository.FilmRepository
import com.example.markiiimark.model.Film
import io.quarkus.test.junit.QuarkusTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals

@QuarkusTest
class FilmRepositoryTest {

	@Inject
	private lateinit var filmRepository: FilmRepository

	@Test
	fun test() {
		val itemFound: Film? =
			filmRepository.findById(5L)
		assertTrue(itemFound != null)
		assertEquals("AFRICAN EGG", itemFound?.title)

	}
}