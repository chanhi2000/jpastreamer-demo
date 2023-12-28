package com.example.markiiimark

import com.example.markiiimark.model.Film
import com.example.markiiimark.repository.FilmRepository
import com.example.markiiimark.repository.FilmRepositoryJpaStreamerKt
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import java.util.stream.Collectors
import kotlin.jvm.optionals.getOrNull

@Path("/")
class FilmResource {
	@Inject private lateinit var filmRepository: FilmRepository

	@GET
	@Path("/helloWorld")
	@Produces(MediaType.TEXT_PLAIN)
	fun hello(): String = "hello world!"

	@GET
	@Path("/film/{filmId}")
	@Produces(MediaType.TEXT_PLAIN)
	fun getFilm(filmId: Short): String {
		val filmFound: Film? =
			filmRepository.findById(filmId.toLong())
		return filmFound?.title ?: "NO film was found!"
	}

	@GET
	@Path("/pagedFilms/{page}/{minLength}")
	@Produces(MediaType.TEXT_PLAIN)
	fun paged(page: Long, minLength: Short): String =
		filmRepository.paged(page, minLength)
			.joinToString { it.transformable }

	@GET
	@Path("/actors/{startsWith}/{minLength}")
	@Produces(MediaType.TEXT_PLAIN)
	fun actors(startsWith: String, minLength: Short): String =
		filmRepository.actors(startsWith, minLength).joinToString("\n") {
			"${it.transformable}: ${it.rentalRate}"

		}

	@GET
	@Path("/update/{minLength}/{rentalRate}")
	@Produces(MediaType.TEXT_PLAIN)
	fun update(minLength: Short, rentalRate: Float): String {
		filmRepository.updateRentalRate(minLength, rentalRate)
		return filmRepository.findByMinLength(minLength).joinToString("\n") {
			"${it.transformable}: $${it.rentalRate}"
		}

	}


	/*
	@Inject private lateinit var filmRepositryJpaStreamer: FilmRepositoryJpaStreamerKt


	@GET
	@Path("/film2/{filmId}")
	@Produces(MediaType.TEXT_PLAIN)
	fun getFilm2(filmId: Short): String {
		val filmFound: Film? =
			filmRepositryJpaStreamer.findById(filmId).getOrNull()
		return filmFound?.title ?: "NO film was found!"
	}

	@GET
	@Path("/pagedFilms2/{page}/{minLength}")
	@Produces(MediaType.TEXT_PLAIN)
	fun paged2(page: Long, minLength: Short): String =
		filmRepositryJpaStreamer.paged(page, minLength)
			.map { "${it.title} (${it.length} min)" }
			.collect(Collectors.joining("\n"))

	@GET
	@Path("/actors2/{startsWith}")
	@Produces(MediaType.TEXT_PLAIN)
	fun actors2(startsWith: String): String =
		filmRepositryJpaStreamer.actors(startsWith)
			.map { "${it.title} (${it.length} min): " +
					"${it.actors.map {a ->
						"${a.firstName} ${a.lastName}"
					}.joinToString(", ")}"
			}
			.collect(Collectors.joining("\n"))
	*/
}