package com.example.markiiimark.repository

import com.example.markiiimark.model.Film
//import com.example.markiiimark.model.`Film$`
import com.speedment.jpastreamer.application.JPAStreamer
import com.speedment.jpastreamer.streamconfiguration.StreamConfiguration
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import java.util.*
import java.util.stream.Stream

@ApplicationScoped
class FilmRepositoryJpaStreamerKt {

	@Inject
	private lateinit var jpaStreamer: JPAStreamer

	/*
	fun findById(filmId: Short): Optional<Film> =
			jpaStreamer.stream(Film::class.java)
				.filter(`Film$`.filmId.equal(filmId))
				.findFirst()


	fun paged(page: Long = 1, minLength: Short = 10): Stream<Film> {
		return jpaStreamer.stream(Film::class.java)
			.filter(`Film$`.length.greaterThan(minLength))
			.sorted(`Film$`.length)
			.skip(page * PAGE_SIZE)
			.limit(PAGE_SIZE)
	}

	fun actors(startsWith: String): Stream<Film> {
		val sc: StreamConfiguration<Film> =
			StreamConfiguration.of(Film::class.java).joining(`Film$`.actors)
		return jpaStreamer.stream(sc)
			.filter(`Film$`.title.startsWith(startsWith))
			.sorted(`Film$`.length)
	}
	*/

	companion object {
		const val PAGE_SIZE: Long = 20L
	}
}