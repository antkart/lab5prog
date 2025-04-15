package managers;

import models.*;

import java.time.LocalDateTime;
import java.util.*;
/**
 * Класс {@code CollectionManager} управляет коллекцией объектов {@code Flat}.
 * Предоставляет функциональность для добавления, обновления, удаления, очистки,
 * а также сохранения коллекции во внешний файл.
 * <p>
 * Используется в основном для взаимодействия с пользователем и хранения текущего состояния коллекции.
 */

public class CollectionManager {
    private long currentId = 1;
    private Set<Flat> collection = new LinkedHashSet<>();
    private List<Flat> list = new ArrayList<>(collection);
    private LocalDateTime init = LocalDateTime.now();

    /**
     * Создаёт менеджер коллекции, инициализируя её переданной коллекцией.
     *
     * @param collection исходная коллекция {@code Flat}
     */
    public CollectionManager(Set<Flat> collection) {
        this.collection = collection;
    }

    /**
     * Возвращает текущую коллекцию.
     *
     * @return коллекция {@code Flat}
     */
    public Set<Flat> getCollection() {
        return collection;
    }

    /**
     * Находит {@code Flat} по его ID.
     *
     * @param id идентификатор объекта
     * @return объект {@code Flat} или {@code null}, если не найден
     */
    public Flat getFlatById(long id) {
        for (Flat f : collection) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    /**
     * Проверяет наличие объекта {@code Flat} в коллекции.
     *
     * @param flat объект для проверки
     * @return {@code true}, если объект уже есть в коллекции или равен {@code null}
     */
    public boolean isContain(Flat flat) {
        boolean contain = (flat == null || getFlatById(flat.getId()) != null);
        return contain;
    }

    /**
     * Возвращает следующий доступный ID, которого ещё нет в коллекции.
     *
     * @return свободный ID
     */
    public long getFreeId() {
        while (getFlatById(currentId) != null) {
            ++currentId;
        }
        return currentId;
    }

    /**
     * Добавляет объект {@code Flat} в коллекцию.
     *
     * @param flat объект для добавления
     * @return {@code true}, если объект был успешно добавлен
     */
    public boolean addFlat(Flat flat) {
        if (isContain(flat)) {
            return false;
        }
        collection.add(flat);
        return true;
    }

    /**
     * Обновляет существующий объект {@code Flat} по ID.
     *
     * @param flat объект с новыми данными
     * @return {@code true}, если обновление прошло успешно
     */
    public boolean updateFlat(Flat flat) {
        if(!isContain(flat)) {
            return false;
        }
        collection.remove(getFlatById(flat.getId()));
        collection.add(flat);
        update();
        return true;
    }

    /**
     * Пересортировывает коллекцию в порядке, определяемом методом {@code compareTo}.
     */
    public void update() {
        Collections.sort(list);
        collection = new LinkedHashSet<>(list);
    }

    /**
     * Удаляет элемент из коллекции по ID.
     *
     * @param id идентификатор элемента
     * @return {@code true}, если удаление прошло успешно
     */
    public boolean removeById(long id) {
        Flat flat = getFlatById(id);
        if(flat == null) {
            return false;
        }
        collection.remove(flat);
        return true;
    }

    /**
     * Очищает текущую коллекцию.
     */
    public void clearCollection() {
        collection.clear();
    }

    /**
     * Возвращает время инициализации коллекции.
     *
     * @return объект {@code LocalDateTime}
     */
    public LocalDateTime getInit() {
        return init;
    }

    /**
     * Сохраняет коллекцию в файл через {@code DumpManager}.
     *
     * @param fileName имя файла для сохранения
     */
    public void saveCollection(String fileName) {
        DumpManager.writeCollection(collection, fileName);

    }


}
