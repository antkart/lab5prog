package commands;

import console.Console;
import console.ConsoleMain;
import console.ConsoleSearch;
import managers.CollectionManager;
import models.Flat;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;

/**
 * Класс, представляющий команду для удаления всех элементов коллекции, которые меньше заданного элемента.
 * <p>
 * Эта команда позволяет удалить из коллекции все элементы, значение которых меньше значения заданного элемента.
 * Заданный элемент вводится пользователем с помощью консольного ввода.
 * </p>
 */
public class RemoveLower extends Command {
    CollectionManager collectionManager;

    /**
     * Конструктор для создания команды удаления элементов, меньших заданного.
     *
     * @param collectionManager Менеджер коллекции для выполнения операций удаления.
     */
    public RemoveLower(CollectionManager collectionManager) {
        super("remove_lower {element}", "удалить из коллекции все элементы, меньшие, чем заданный");
        this.collectionManager = collectionManager;
    }

    /**
     * Метод для выполнения команды удаления элементов, меньших заданного.
     * <p>
     * В этом методе пользователь вводит данные для создания нового элемента {@link Flat}.
     * Все элементы коллекции, которые меньше введенного, будут удалены.
     * </p>
     *
     * @param buf Поток ввода для получения данных от пользователя.
     * @throws IOException При ошибке ввода/вывода.
     */
    @Override
    public void execute(BufferedReader buf) throws IOException {
        Console console = new ConsoleMain();
        console.println("Создание нового models.Flat:");
        Flat flat = ConsoleSearch.searchFlat(buf, collectionManager.getFreeId());
        Set<Flat> flatSet = collectionManager.getCollection();
        for(Flat element : flatSet) {
            if (element.compareTo(flat) < 0) {
                collectionManager.removeById(element.getId());
            }
        }

    }
}
