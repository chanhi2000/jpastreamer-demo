package com.example.markiiimark.model

import jakarta.persistence.*
import java.io.Serializable
import java.sql.Timestamp

@Entity
@Table(name="film", schema="sakila")
class Film(
	@Id
	@Column(name="film_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	var filmId: Short = -1,
	@Basic
	var title: String = "",
	var length:	Short = 0
): Serializable {
	@Basic
	var description: String? = ""
	@Basic
	@Column(name="release_year")
	var releaseYear: Int? = 0
	@Basic
	@Column(name="language_id")
	var languageId:	Short? = 0
	@Basic
	@Column(name="original_language_id")
	var originalLanguageId:	Short? = 0

	@Column(name="rental_duration")
	var rentalDuration:	Short? = 0
	@Column(name="rental_rate")
	var rentalRate: Float = 0f
	@Column(name="replacement_cost")
	var replacementCost: Float = 0f
	@Column(name="rating", columnDefinition="enum ('G','PG','PG-13','R','NC-17')")
	@Transient
	var rating: Any? = null
	@Column(name="special_features", columnDefinition="set('Trailers','Commentaries','Deleted Scenes','Behind the Scenes')")
	@Transient
	var specialFeatures: Any? = null
	@Column(name="last_update")
	var lastUpdate: Timestamp? = null
	@ManyToMany(cascade=[CascadeType.ALL], targetEntity=Actor::class)
	@JoinTable(
		name="film_actor",
		joinColumns= [JoinColumn(name = "film_id")],
		inverseJoinColumns = [JoinColumn(name = "actor_id")]
	)
	var actors: List<Actor> = listOf()

	val transformable: String
		get() = "$title (${length} min)"
	val actorNames: String
		get() = actors.joinToString(", ") { a -> a.fullName }
}
