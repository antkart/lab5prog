package commands;

import console.ConsoleMain;
import managers.CollectionManager;
import models.Flat;
import console.Console;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;

/**
 * Команда для вычисления и вывода среднего значения поля numberOfRooms
 * для всех элементов коллекции {@link CollectionManager}.
 * <p>
 * Эта команда перебирает все элементы в коллекции, суммирует значения поля numberOfRooms
 * и вычисляет среднее значение. После вычисления, среднее значение выводится в консоль.
 * </p>
 */
public class AverageOfNumberOfRooms extends Command {
    CollectionManager collectionManager;

    /**
     * Конструктор команды AverageOfNumberOfRooms.
     *
     * @param collectionManager менеджер коллекции, из которой будут взяты данные
     */
    public AverageOfNumberOfRooms(CollectionManager collectionManager) {
        super("average_of_number_of_rooms", "вывести среднее значение поля numberOfRooms для всех элементов коллекции");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(BufferedReader buf) throws IOException {

    }

    /**
     * Выполняет команду для вычисления среднего значения поля numberOfRooms
     * для всех элементов коллекции.
     * <p>
     * Метод перебирает все элементы коллекции, суммирует значение их поля numberOfRooms,
     * а затем вычисляет среднее значение. Если коллекция пуста, метод пропускает вычисление.
     * После вычисления, результат выводится в консоль.
     * </p>
     */
    public void execute() {
        Set<Flat> flatSet = collectionManager.getCollection();
        Console console = new ConsoleMain();
        int sum = 0;
        float average;
        for (Flat element : flatSet) {
            sum += element.getNumbersOfRooms();
        }
        average = (float) sum / flatSet.size();
    }
}
