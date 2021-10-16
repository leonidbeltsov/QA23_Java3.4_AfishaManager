package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FilmManagerTest {
    // Подготавливаем данные
    Film one = new Film(1, "Bloodshot", "action", false);
    Film two = new Film(2, "Onward", "cartoon", false);
    Film three = new Film(3, "Hotel Belgrade", "comedy", false);
    Film four = new Film(4, "The Gentlemen", "action", false);
    Film five = new Film(5, "The Invisible Man", "horror", false);
    Film six = new Film(6, "Trolls World Tour", "cartoon", true);
    Film seven = new Film(7, "Number one", "comedy", true);
    Film eigth = new Film(8, "Dune", "fantastic", false);
    Film nine = new Film(9, "My son", "drama", false);
    Film ten = new Film(10, "Eiffel", "drama", true);
    Film eleven = new Film(11, "Combat Wombat", "cartoon", false);

    @Test
    void shouldGetLastFilmsBelowLimit() {
        FilmManager manager = new FilmManager();
        manager.addFilm(one);
        manager.addFilm(two);
        manager.addFilm(three);
        manager.addFilm(four);
        manager.addFilm(five);
        manager.addFilm(six);
        manager.addFilm(seven);

        Film[] actual = manager.getLastFilms();
        Film[] expected = new Film[]{seven, six, five, four, three, two, one};
        // Сравниваем два массива
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLastFilmsAboveLimit() {
        FilmManager manager = new FilmManager();
        manager.addFilm(one);
        manager.addFilm(two);
        manager.addFilm(three);
        manager.addFilm(four);
        manager.addFilm(five);
        manager.addFilm(six);
        manager.addFilm(seven);
        manager.addFilm(eigth);
        manager.addFilm(nine);
        manager.addFilm(ten);
        manager.addFilm(eleven);

        Film[] actual = manager.getLastFilms();
        Film[] expected = new Film[]{eleven, ten, nine, eigth, seven, six, five, four, three, two};
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldGetLastSomeFilmsBelowLimit() {
        FilmManager manager = new FilmManager(3);
        manager.addFilm(one);
        manager.addFilm(two);
        manager.addFilm(three);
        manager.addFilm(four);
        manager.addFilm(five);
        manager.addFilm(six);
        manager.addFilm(seven);

        Film[] actual = manager.getLastFilms();
        Film[] expected = new Film[]{seven, six, five};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLastSomeFilmsAboveLimit() {
        FilmManager manager = new FilmManager(9);
        manager.addFilm(one);
        manager.addFilm(two);
        manager.addFilm(three);
        manager.addFilm(four);
        manager.addFilm(five);
        manager.addFilm(six);
        manager.addFilm(seven);

        Film[] actual = manager.getLastFilms();
        Film[] expected = new Film[]{seven, six, five, four, three, two, one};
        assertArrayEquals(expected, actual);
    }
}