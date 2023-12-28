package com.example.markiiimark.repository

import com.example.markiiimark.model.Film
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional

@ApplicationScoped
class FilmRepository : 	PanacheRepository<Film> {

	fun findByMinLength(minLength: Short): List<Film> =
		listAll().filter { it.length > minLength }
			.sortedBy { it.length }

	fun paged(page: Long = 0, minLength: Short = 10): List<Film> =
		findByMinLength(minLength)
			.take(((page+1)*PAGE_SIZE).toInt())
			.drop((page* PAGE_SIZE).toInt())

	fun actors(startsWith: String, minLength: Short): List<Film> {
		return findByMinLength(minLength).filter { it.title.startsWith(startsWith)  }
			.sortedBy { it.length }
	}

	@Transactional
	fun updateRentalRate(minLength: Short, rentalRate: Float) {
		return findByMinLength(minLength).forEach {
			it.rentalRate = rentalRate
		}
	}
	companion object {
		const val PAGE_SIZE: Long = 20L
	}
}