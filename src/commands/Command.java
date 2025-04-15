package commands;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Абстрактный класс для представления команды в приложении.
 * <p>
 * Этот класс является базовым для всех команд в приложении. Каждая команда должна реализовывать метод
 * {@link #execute(BufferedReader)} для выполнения своей логики.
 * </p>
 */
abstract public class Command {
    private final String description;
    private final String name;

    /**
     * Конструктор для создания команды с заданным названием и описанием.
     *
     * @param name        название команды
     * @param description описание команды
     */
    public Command(String name, String description) {
        this.description = description;
        this.name = name;
    }

    /**
     * Выполняет команду.
     * <p>
     * Этот метод должен быть реализован в подклассах для выполнения конкретной логики команды.
     * </p>
     *
     * @param buf {@link BufferedReader} для чтения ввода пользователя, если необходимо
     * @throws IOException если возникает ошибка ввода-вывода
     */
    public abstract void execute(BufferedReader buf) throws IOException;

    /**
     * Возвращает название команды.
     *
     * @return название команды
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает описание команды.
     *
     * @return описание команды
     */
    public String getDescription() {
        return description;
    }
}
