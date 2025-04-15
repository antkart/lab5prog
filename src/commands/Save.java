package commands;

import managers.CollectionManager;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Класс, представляющий команду для сохранения коллекции в файл.
 * <p>
 * Эта команда сохраняет текущую коллекцию объектов в файл с заданным именем.
 * </p>
 */
public class Save extends Command {
    String fileName;
    CollectionManager collectionManager;

    /**
     * Конструктор для создания команды сохранения коллекции в файл.
     *
     * @param collectionManager Менеджер коллекции для выполнения операции сохранения.
     * @param fileName         Имя файла, в который будет сохранена коллекция.
     */
    public Save(CollectionManager collectionManager, String fileName) {
        super("save", "сохранить коллекцию в файл");
        this.collectionManager = collectionManager;
        this.fileName = fileName;
    }


    @Override
    public void execute(BufferedReader buf) throws IOException {

    }

    /**
     * Метод для сохранения коллекции в файл.
     * Этот метод сохраняет коллекцию, используя метод CollectionManager.saveCollection.
     */
    public void execute() {
        collectionManager.saveCollection(fileName);
    }
}
