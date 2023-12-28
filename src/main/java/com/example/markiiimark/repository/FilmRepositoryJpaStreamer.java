package com.example.markiiimark.repository;

import com.example.markiiimark.model.Film;
import com.speedment.jpastreamer.application.JPAStreamer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

@ApplicationScoped
class FilmRepositoryJpaStreamer {

    private static final int PAGE_SIZE = 20;

    @Inject
    private JPAStreamer jpaStreamer;

    /*
    public Optional<Film> findById(short filmId) {
        return jpaStreamer.stream(Film.class)
                .filter(Film$.filmId.equal(filmId))
                .findFirst();
    }
    */
}
