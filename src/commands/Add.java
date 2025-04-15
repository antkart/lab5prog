package commands;


import console.ConsoleMain;
import console.ConsoleSearch;
import managers.CollectionManager;
import models.Flat;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Команда для добавления нового элемента {@link Flat} в коллекцию.
 * <p>
 * Эта команда запрашивает у пользователя все необходимые данные для
 * создания нового объекта {@link Flat} и добавляет его в коллекцию,
 * управляемую объектом {@link CollectionManager}.
 * </p>
 */
public class Add extends Command {
    CollectionManager collectionManager;

    /**
     * Конструктор команды Add.
     *
     * @param collectionManager менеджер коллекции, в которую будет добавлен новый элемент
     */
    public Add(CollectionManager collectionManager) {
        super("add {element}", "добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет добавление нового объекта {@link Flat} в коллекцию.
     * <p>
     * Метод запрашивает у пользователя данные для создания нового объекта {@link Flat},
     * используя {@link ConsoleSearch}. Затем добавляет его в коллекцию, используя метод
     * {@link CollectionManager#addFlat(Flat)}.
     * </p>
     *
     * @param buf {@link BufferedReader} для чтения ввода пользователя
     * @throws IOException если возникает ошибка при чтении ввода пользователя
     */
    @Override
    public void execute(BufferedReader buf) throws IOException {
        ConsoleMain console = new ConsoleMain();
        console.println("Создание нового models.Flat:");
        Flat flat = ConsoleSearch.searchFlat(buf, collectionManager.getFreeId());
        collectionManager.addFlat(flat);

    }
}
