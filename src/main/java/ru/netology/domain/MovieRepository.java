package ru.netology.domain;

public class MovieRepository {
    private Movie[] movies = new Movie[0];

    //    findAll - возвращает массив всех хранящихся в массиве объектов
    public Movie[] findAll() {
        return movies;
    }

    //    save - добавляет объект в массив
    public void save(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    //     findById - возвращает объект по идентификатору (либо null, если такого объекта нет)
    public Movie findById(int id) {
        Movie result = null;
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                result = movie;
            }
        }
        return result;
    }

    //    removeById - удаляет объект по идентификатору (если объекта нет, то пусть будет исключение, как на лекции)
    public void removeById(int id) {
        Movie[] tmp = new Movie[movies.length - 1];
        int index = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    //    removeAll* - полностью вычищает репозиторий (для удаления всех элементов достаточно в поле items положить пустой массив)
    public void removeAll() {
        movies = new Movie[0];
    }
}
