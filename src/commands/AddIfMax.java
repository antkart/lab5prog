package commands;

import console.Console;
import console.ConsoleMain;
import console.ConsoleSearch;
import managers.CollectionManager;
import models.Flat;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Команда для добавления нового элемента {@link Flat} в коллекцию,
 * если его значение превышает значение наибольшего элемента в коллекции.
 * <p>
 * Эта команда позволяет добавлять новый элемент в коллекцию {@link CollectionManager},
 * только если значение нового элемента больше, чем значение наибольшего элемента в текущей коллекции.
 * Если коллекция пуста, новый элемент будет добавлен, так как отсутствуют элементы для сравнения.
 * </p>
 */
public class AddIfMax extends Command {
    CollectionManager collectionManager;

    /**
     * Конструктор команды AddIfMax.
     *
     * @param collectionManager менеджер коллекции, в которую будет добавлен новый элемент
     */
    public AddIfMax(CollectionManager collectionManager) {
        super("add_if_max {element}", "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет добавление нового объекта {@link Flat} в коллекцию, если его значение больше,
     * чем значение наибольшего элемента в коллекции.
     * <p>
     * Метод запрашивает у пользователя данные для создания нового объекта {@link Flat}.
     * Затем находит наибольший элемент в коллекции и сравнивает его с новым объектом.
     * </p>
     *
     * @param buf {@link BufferedReader} для чтения ввода пользователя
     * @throws IOException если возникает ошибка при чтении ввода пользователя
     */
    @Override
    public void execute(BufferedReader buf) throws IOException {
        Console console = new ConsoleMain();
        console.println("Создание нового models.Flat:");
        Flat flat = ConsoleSearch.searchFlat(buf, collectionManager.getFreeId());
        Flat maxFlat = collectionManager.getCollection().stream().max(Flat::compareTo).orElse(null);
        if(maxFlat == null) {
            System.out.println("Коллекция пуста");
        } else {
            if (flat.compareTo(maxFlat) > 0) {
                collectionManager.addFlat(flat);
            }
        }

    }
}
