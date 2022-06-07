package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerAfishaTest {
    private ManagerAfisha manager = new ManagerAfisha();
    private MovieRepository repository = new MovieRepository();
    private Movie first = new Movie(1, "Pulp Fiction", 1994);
    private Movie second = new Movie(2, "The Terminator", 1984);
    private Movie third = new Movie(3, "Psycho", 1960);
    private Movie fourth = new Movie(4, "Interstellar", 2014);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    public void shouldFinfAll() {
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFinfById() {
        Movie actual = repository.findById(2);
        Movie expected = second;
        assertEquals(actual, expected);
    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(2);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, third};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldRemoveAll() {
        repository.removeAll();
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[0];
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldGetLastMovieWithLimit() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        Movie[] actual = manager.findLast();
        Movie[] expected = new Movie[]{third, second, first};
        assertArrayEquals(actual, expected);
    }
}