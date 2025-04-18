package commands;

import console.Console;
import console.ConsoleMain;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Класс, представляющий команду вывода справки по доступным командам.
 * <p>
 * Эта команда выводит список всех доступных команд с кратким описанием их назначения.
 * </p>
 */
public class Help extends Command {

    /**
     * Конструктор для создания команды вывода справки.
     */
    public Help() {
        super("help", "вывести справку по доступным командам");
    }

    @Override
    public void execute(BufferedReader buf) throws IOException {

    }

    /**
     * Метод для выполнения команды.
     * <p>
     * Этот метод выводит список всех доступных команд с описанием их назначения.
     * </p>
     */
    public void execute() {
        Console console = new ConsoleMain();
        console.println("help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
                "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный\n" +
                "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                "average_of_number_of_rooms : вывести среднее значение поля numberOfRooms для всех элементов коллекции\n" +
                "filter_less_than_view view : вывести элементы, значение поля view которых меньше заданного\n" +
                "print_unique_furnish : вывести уникальные значения поля furnish всех элементов в коллекции\n");

    }
}
