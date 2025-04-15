package commands;

import managers.CollectionManager;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Команда для очистки коллекции {@link CollectionManager}.
 * <p>
 * Эта команда удаляет все элементы из коллекции, очищая её.
 * </p>
 */
public class Clear extends Command {
    CollectionManager collectionManager;

    /**
     * Конструктор команды Clear.
     *
     * @param collectionManager менеджер коллекции, которую нужно очистить
     */
    public Clear(CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(BufferedReader buf) throws IOException {

    }

    /**
     * Выполняет команду очистки коллекции.
     * <p>
     * Этот метод очищает коллекцию, удаляя все её элементы.
     * </p>
     */
    public void execute() {
        collectionManager.clearCollection();
    }
}
