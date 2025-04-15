package commands;

import console.Console;
import console.ConsoleMain;
import managers.CollectionManager;
import models.Flat;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;

/**
 * Класс, представляющий команду для вывода всех элементов коллекции.
 * <p>
 * Эта команда выводит в стандартный поток вывода все элементы коллекции в строковом представлении.
 * </p>
 */
public class Show extends Command {
    CollectionManager collectionManager;

    /**
     * Конструктор для создания команды вывода всех элементов коллекции.
     *
     * @param collectionManager Менеджер коллекции для доступа к данным коллекции.
     */
    public Show(CollectionManager collectionManager) {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionManager = collectionManager;
    }


    @Override
    public void execute(BufferedReader buf) throws IOException {

    }

    /**
     * Метод для вывода всех элементов коллекции в стандартный поток вывода.
     * <p>
     * Этот метод перебирает все элементы коллекции и выводит их с помощью Console.println.
     * </p>
     */
    public void execute() {
        Console console = new ConsoleMain();
        Set<Flat> flatSet = collectionManager.getCollection();
        for (Flat element : flatSet) {
            console.println(element);
        }
    }
}
