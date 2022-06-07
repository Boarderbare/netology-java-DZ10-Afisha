package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ManagerAfisha {
    private MovieRepository repo;
    private int limit = 10;
    private ManagerAfisha(int limit, MovieRepository repo) {
        this.repo = repo;
        this.limit = limit;
    }

//    public ManagerAfisha(int limit) {
//        this.limit = limit;
//    }

    public void add(Movie movie) {
        repo.save(movie);
    }

    public Movie find(int id) {
        return repo.findById(id);
    }

    public Movie[] all() {
        return repo.findAll();
    }

    public Movie[] findLast() {
        int length = all().length;
        int resultLenght;
        if (limit > length) {
            resultLenght = length;
        } else {
            resultLenght = limit;
        }
        Movie[] tmp = all();
        Movie[] result = new Movie[resultLenght];
        for (int i = 0; i < resultLenght; i++) {
            int index = length - i - 1;
            result[i] = tmp[index];
        }
        return result;
    }
}
