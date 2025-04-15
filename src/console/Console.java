package console;

import java.io.BufferedReader;
import java.io.IOException;
/**
 * Интерфейс, определяющий методы для взаимодействия с консолью.
 * <p>
 * Предоставляет базовые методы для вывода данных и чтения ввода пользователя.
 */
public interface Console {
    /**
     * Выводит объект в консоль без перехода на новую строку.
     *
     * @param object объект для вывода
     */
    void print(Object object);


    /**
     * Выводит объект в консоль с переходом на новую строку.
     *
     * @param object объект для вывода
     */
    void println(Object object);

    /**
     * Считывает строку из заданного {@link BufferedReader}.
     *
     * @param bufferedReader источник ввода
     * @return считанная строка
     * @throws IOException если происходит ошибка чтения
     */
    String readln(BufferedReader bufferedReader) throws IOException;


}
