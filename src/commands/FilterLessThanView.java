package commands;

import console.Console;
import console.ConsoleMain;
import managers.CollectionManager;
import models.Flat;
import models.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;

/**
 * Класс, представляющий команду фильтрации элементов коллекции, значение поля View
 * которых меньше заданного значения {@link View}.
 * <p>
 * Эта команда выводит все элементы коллекции, для которых значение поля {@code view} меньше, чем
 * переданное значение в команду.
 * </p>
 */
public class FilterLessThanView extends Command {
    CollectionManager collectionManager;
    View view;

    /**
     * Конструктор для создания команды фильтрации элементов по значению поля View.
     *
     * @param collectionManager Менеджер коллекции, с которой работает команда.
     * @param view Значение {@link View}, с которым будут сравниваться элементы коллекции.
     */
    public FilterLessThanView(CollectionManager collectionManager, View view) {
        super("filter_less_than_view view", "вывести элементы, значение поля view которых меньше заданного");
        this.collectionManager = collectionManager;
        this.view = view;
    }

    @Override
    public void execute(BufferedReader buf) throws IOException {

    }

    /**
     * Метод для выполнения команды фильтрации элементов по значению поля View.
     * <p>
     * Этот метод проходит по всем элементам коллекции и выводит те из них, у которых значение
     * поля {@code view} меньше заданного значения {@link View}.
     * </p>
     */
    public void execute() {
        Console console = new ConsoleMain();
        Set<Flat> flatSet = collectionManager.getCollection();
        View viewElement;
        for(Flat element : flatSet) {
            viewElement = element.getView();
            if(viewElement.compareTo(view) < 0) {
                console.println(element);
            }
        }
    }

}
