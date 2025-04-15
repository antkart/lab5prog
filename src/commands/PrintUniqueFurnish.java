package commands;

import console.Console;
import console.ConsoleMain;
import managers.CollectionManager;
import models.Flat;
import models.Furnish;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Класс, представляющий команду для вывода уникальных значений поля furnish всех элементов коллекции.
 * <p>
 * Эта команда создает множество уникальных значений для поля furnish в коллекции объектов {@link Flat}
 * и выводит их в стандартный поток вывода.
 * </p>
 */
public class PrintUniqueFurnish extends Command {
    CollectionManager collectionManager;

    /**
     * Конструктор для создания команды вывода уникальных значений поля furnish.
     *
     * @param collectionManager Менеджер коллекции для получения элементов коллекции.
     */
    public PrintUniqueFurnish(CollectionManager collectionManager) {
        super("print_unique_furnish", "вывести уникальные значения поля furnish всех элементов в коллекции");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(BufferedReader buf) throws IOException {

    }

    /**
     * Выполняет команду, выводя уникальные значения поля furnish всех элементов коллекции.
     * <p>
     * Для каждого объекта {@link Flat} в коллекции извлекается значение поля furnish.
     * Эти значения добавляются в множество (сохраняя уникальность), после чего множество выводится в консоль.
     * </p>
     */
    public void execute() {
        Console console = new ConsoleMain();
        Set<Flat> flatSet = collectionManager.getCollection();
        Set<Furnish> furnishSet = new LinkedHashSet<>();
        Furnish furnish;
        for(Flat element : flatSet) {
            furnish = element.getFurnish();
            furnishSet.add(furnish);
        }
        console.println(furnishSet);
    }
}
