package commands;

import console.Console;
import console.ConsoleMain;
import managers.CollectionManager;
import models.Flat;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Класс, представляющий команду для вывода информации о коллекции.
 * <p>
 * Эта команда выводит в стандартный поток вывода информацию о коллекции:
 * тип данных, дата инициализации, а также количество элементов в коллекции.
 * </p>
 */
public class Info extends Command {
    CollectionManager collectionManager;

    /**
     * Конструктор для создания команды вывода информации о коллекции.
     *
     * @param collectionManager Менеджер коллекции для получения информации.
     */
    public Info(CollectionManager collectionManager) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(BufferedReader buf) throws IOException {

    }

    /**
     * Выполняет команду, выводя информацию о коллекции.
     * <p>
     * Выводит следующие данные:
     *Тип данных, хранящихся в коллекции (объекты класса {@link Flat})
     *Дата инициализации коллекции
     *Количество элементов в коллекции
     * </p>
     */
    public void execute() {
        LocalDateTime init = collectionManager.getInit();
        Set<Flat> flatSet = collectionManager.getCollection();
        long size = flatSet.size();
        Console console = new ConsoleMain();
        console.println("Тип данных, хранящихся в коллекции: объекты класса models.Flat,\n" +
                "Дата инициализации: " + init + ",\n" +
                "Количество элементов в коллекции: " + size + ".");
    }
}
