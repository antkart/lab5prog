package console;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Реализация интерфейса {@link Console}, обеспечивающая
 * ввод и вывод данных через стандартную консоль.
 */
public class ConsoleMain implements Console {

    /**
     * Выводит объект в консоль без перехода на новую строку.
     *
     * @param object объект для вывода
     */
    @Override
    public void print(Object object) {
        System.out.print(object.toString());
    }

    /**
     * Выводит объект в консоль с переходом на новую строку.
     *
     * @param object объект для вывода
     */
    @Override
    public void println(Object object) {
        System.out.println(object.toString());
    }

    /**
     * Считывает строку из заданного {@link BufferedReader}.
     *
     * @param buf источник ввода
     * @return считанная строка
     * @throws IOException если происходит ошибка чтения
     */
    @Override
    public String readln(BufferedReader buf) throws IOException {
        return buf.readLine();
    }
}
