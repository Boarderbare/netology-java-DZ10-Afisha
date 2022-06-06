package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerAfishaTest {
    private ManagerAfisha manager = new ManagerAfisha();
    private Movie first = new Movie(1, "Pulp Fiction", 1994);
    private Movie second = new Movie(2, "The Terminator", 1984);
    private Movie third = new Movie(3, "Psycho", 1960);
    private Movie fourth = new Movie(4, "Interstellar", 2014);

    @BeforeEach
    public void setUp() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
    }

    @Test
    public void shouldAddMovie() {
        manager.addMovie(fourth);
        Movie[] actual = manager.getMovies();
        Movie[] expected = new Movie[]{first, second, third, fourth};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldGetAll() {
        Movie[] actual = manager.findAll();
        Movie[] expected = new Movie[]{first, second, third};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldGetLastMovieWithLimit() {
        Movie[] actual = manager.findLast();
        Movie[] expected = new Movie[]{third, second, first};
        assertArrayEquals(actual, expected);
    }
}