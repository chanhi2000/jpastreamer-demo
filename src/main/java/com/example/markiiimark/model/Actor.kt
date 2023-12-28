package com.example.markiiimark.model

import jakarta.persistence.*
import java.io.Serializable
import java.sql.Timestamp

@Entity
@Table(name="actor", schema="sakila")
class Actor: Serializable {
	@Id
	@Column(name="actor_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	var actorId: Short = -1
	@Basic
	@Column(name="first_name")
	var firstName: String = ""
	@Basic
	@Column(name="last_name")
	var lastName: String = ""
	@Column(name="last_update")
	var lastUpdate: Timestamp? = null
	@ManyToMany(mappedBy="actors", targetEntity=Film::class, fetch=FetchType.LAZY)
	var films: Set<Film> = setOf()
//	constructor() : this(0, "", "", null)
	val fullName: String
		get() = "$firstName $lastName"
}