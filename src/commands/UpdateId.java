package commands;

import console.ConsoleMain;
import console.ConsoleSearch;
import managers.CollectionManager;
import models.Flat;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Класс, представляющий команду для обновления элемента коллекции по его id.
 * <p>
 * Эта команда обновляет значение элемента коллекции, у которого id совпадает с заданным.
 * </p>
 */
public class UpdateId  extends Command {
    CollectionManager collectionManager;
    long id;

    /**
     * Конструктор для создания команды обновления элемента коллекции по id.
     *
     * @param collectionManager Менеджер коллекции для доступа и модификации коллекции.
     * @param id               Идентификатор элемента коллекции, который будет обновлен.
     */
    public UpdateId(CollectionManager collectionManager, long id) {
        super("update id {element}", "обновить значение элемента коллекции, id которого равен заданному");
        this.collectionManager = collectionManager;
        this.id = id;
    }

    /**
     * Метод для выполнения команды обновления элемента коллекции по id.
     * <p>
     * Этот метод запрашивает у пользователя новый объект {@link Flat}, используя ConsoleSearch.searchFlat,
     * и затем обновляет соответствующий элемент в коллекции.
     * </p>
     *
     * @param buf Поток ввода для получения данных от пользователя.
     * @throws IOException При ошибке ввода/вывода.
     */
    @Override
    public void execute(BufferedReader buf) throws IOException {
        ConsoleMain console = new ConsoleMain();
        console.println("Обновление models.Flat:");
        Flat flat = ConsoleSearch.searchFlat(buf, id);
        collectionManager.updateFlat(flat);
    }
}
