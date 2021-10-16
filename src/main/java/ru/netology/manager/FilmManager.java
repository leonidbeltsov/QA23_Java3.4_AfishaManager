package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.Film;

@NoArgsConstructor

public class FilmManager {
    Film[] films = new Film[0];
    private int arrayLength = 10;

    //  Добавим дополнителый конструктор, для задания размера отдаваемого массива
    public FilmManager(int arrayLength) {
        this.arrayLength = arrayLength;
    }

    //  Добавляем фильм в массив фильмов
    public void addFilm(Film film) {
        //  Создаем новый (временный) массив tmp длиной на еденицу больше длины массива films
        Film[] tmp = new Film[films.length + 1];
        /*
        Копироем поочередно элементы массива films в массив tmp используя цикл for
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        */
        //  Копироем поочередно элементы массива films в массив tmp используюя .arraycopy
        System.arraycopy(films, 0, tmp, 0, films.length);
        //  Кладем в последнюю ячейку массива tmp массив film полученый на входе метода
        tmp[tmp.length - 1] = film;
        //  Переносим всё из массива tmp в массив film
        films = tmp;
    }

    //  Возвращает последние 10 добавленных фильмов в обратном порядке
    public Film[] getLastFilms() {
        //  Вводим переменную resultLength определяющую длину отдаваемого методом массива
        int resultLength;
        /*
        Cравниваем resultLength c arrayLength и в случае, если длина массива films превышает значение требуемой
        длины отдаваемого методом массива, приравниваем длину отдаваемого массива к требуемой, в противном случае отдаем
        "всё, что есть".
        arrayLength - ожидаемая длина возвращаемого массива
        resultLength - фактическая длина возвращаемого массива
        */
        if (films.length > arrayLength) {
            resultLength = arrayLength;
        } else {
            resultLength = films.length;
        }
        /*
        Создаем новый (временный) массив tmp и складываем в него в обратном порядке элементы массива films, начиная
         с последнего элемента
         */
        Film[] tmp = new Film[resultLength];
        for (int i = 0; i < resultLength; i++) {
            //  Ищем индекс последнего элемента в массиве films
            tmp[i] = films[films.length - i - 1];
        }
        //  Возвращаем полученный массив
        return tmp;
    }
}