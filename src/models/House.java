package models;

/**
 * Класс, представляющий дом, в котором может находиться квартира.
 * <p>
 * Этот класс реализует интерфейс {@link Validatable} для проверки валидности данных.
 * </p>
 */
public class House implements Validatable {
    private String name; //Поле может быть null
    private Integer year; //Значение поля должно быть больше 0
    private long numberOfFlatsOnFloor; //Значение поля должно быть больше 0

    /**
     * Конструктор для создания объекта {@link House} с заданными значениями.
     *
     * @param name                 Название дома (может быть null).
     * @param year                 Год постройки дома (должен быть больше 0).
     * @param numberOfFlatsOnFloor Количество квартир на этаже (должно быть больше 0).
     */
    public House(String name, Integer year, long numberOfFlatsOnFloor) {
        this.name = name;
        this.year = year;
        this.numberOfFlatsOnFloor = numberOfFlatsOnFloor;
    }

    /**
     * Метод для валидации данных объекта {@link House}.
     * <p>
     * Проверяется, что:
     * - year больше 0
     * - numberOfFlatsOnFloor больше 0
     * </p>
     *
     * @return {@code true}, если все поля валидны, иначе {@code false}.
     */
    @Override
    public boolean validate() {
        boolean res = (year > 0) && (numberOfFlatsOnFloor > 0);
        return res;
    }

    /**
     * Переопределенный метод toString, который возвращает строковое представление объекта House.
     *
     * @return Строковое представление объекта House.
     */
    @Override
    public String toString() {
        return "{name: " + name + ", year: " + year + ", numberOfFlatsOnFloor: " + numberOfFlatsOnFloor + "}";
    }
 }

