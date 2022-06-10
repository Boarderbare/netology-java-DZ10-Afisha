package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;


public class ManagerAfishaWithLimitTest{
    private MovieRepository repository = Mockito.mock(MovieRepository.class);
    private ManagerAfisha manager = new ManagerAfisha(repository, 3);

    private Movie first = new Movie(1, "Pulp Fiction", 1994);
    private Movie second = new Movie(2, "The Terminator", 1984);
    private Movie third = new Movie(3, "Psycho", 1960);
    private Movie fourth = new Movie(4, "Interstellar", 2014);


    @Test
    public void shouldGetLastMovieWithLimitManual() {
        Movie[] returned= new Movie[]{first,second,third,fourth};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.findLast();
        Movie[] expected = new Movie[]{fourth, third, second};
        assertArrayEquals(actual, expected);

        verify(repository, times(2)).findAll();
    }
}
