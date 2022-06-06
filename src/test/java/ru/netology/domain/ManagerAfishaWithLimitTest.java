package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerAfishaWithLimitTest {

    private ManagerAfisha manager = new ManagerAfisha(3);
    private Movie first = new Movie(1, "Pulp Fiction", 1994);
    private Movie second = new Movie(2, "The Terminator", 1984);
    private Movie third = new Movie(3, "Psycho", 1960);
    private Movie fourth = new Movie(4, "Interstellar", 2014);

    @BeforeEach
    public void setUp() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
    }

    @Test
    public void shouldGetLastMovieWithLimitManual() {
        Movie[] actual = manager.findLast();
        Movie[] expected = new Movie[]{fourth, third, second};
        assertArrayEquals(actual, expected);
    }
}
