package commands;

import managers.CollectionManager;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Класс, представляющий команду для удаления элемента из коллекции по его id.
 * <p>
 * Эта команда позволяет удалить элемент коллекции {@link models.Flat}, идентифицированный по его уникальному id.
 * </p>
 */
public class RemoveById extends Command {
    long id;
    CollectionManager collectionManager;

    /**
     * Конструктор для создания команды удаления элемента по id.
     *
     * @param collectionManager Менеджер коллекции для выполнения операций удаления.
     * @param id               Уникальный идентификатор элемента коллекции, который будет удален.
     */
    public RemoveById(CollectionManager collectionManager, long id) {
        super("remove_by_id id", "удалить элемент из коллекции по его id");
        this.id = id;
        this.collectionManager = collectionManager;
    }


    @Override
    public void execute(BufferedReader buf) throws IOException {

    }

    /**
     * Выполняет команду удаления элемента из коллекции по id.
     * <p>
     * Этот метод вызывает метод CollectionManager.removeById для удаления элемента коллекции,
     * чье id совпадает с переданным значением.
     * </p>
     */
    public void execute() {
        collectionManager.removeById(id);
    }
}
