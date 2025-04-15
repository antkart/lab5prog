package commands;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Класс, представляющий команду завершения программы.
 * <p>
 * Эта команда завершает выполнение программы без сохранения в файл.
 * </p>
 */
public class Exit extends Command {

    /**
     * Конструктор для создания команды завершения программы.
     */
     public Exit() {
         super("exit",  "завершить программу (без сохранения в файл)");
     }


    @Override
    public void execute(BufferedReader buf) throws IOException {

    }

    /**
     * Завершает выполнение программы без сохранения в файл.
     * <p>
     * Этот метод вызывает System.exit с кодом 0 для завершения программы.
     * </p>
     */
    public void execute() {
         System.exit(0);
    }
}
