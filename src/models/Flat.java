package models;

import java.time.LocalDateTime;

/**
 * Класс, представляющий объект квартиры с различными характеристиками.
 * <p>
 * Этот класс реализует интерфейсы {@link Comparable} для сравнения объектов и {@link Validatable} для проверки валидности данных.
 * </p>
 */
public class Flat implements Comparable<Flat>, Validatable {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long area; //Значение поля должно быть больше 0
    private long numberOfRooms; //Значение поля должно быть больше 0
    private Furnish furnish; //Поле не может быть null
    private View view; //Поле не может быть null
    private Transport transport; //Поле может быть nul
    private House house; //Поле может быть null

    /**
     * Конструктор для создания объекта {@link Flat} с заданными значениями.
     *
     * @param id            Уникальный идентификатор квартиры (должен быть больше 0).
     * @param name          Название квартиры (не может быть пустым).
     * @param coordinates   Координаты квартиры.
     * @param creationDate  Дата создания квартиры (будет автоматически генерироваться).
     * @param area          Площадь квартиры (должна быть больше 0).
     * @param numberOfRooms Количество комнат (должно быть больше 0).
     * @param furnish       Тип отделки квартиры.
     * @param view          Вид из окна квартиры.
     * @param transport     Тип транспорта вблизи квартиры.
     * @param house         Дом, в котором находится квартира.
     */
    public Flat(Long id, String name, Coordinates coordinates, LocalDateTime creationDate, long area, long numberOfRooms, Furnish furnish, View view, Transport transport, House house) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.furnish = furnish;
        this.view = view;
        this.transport = transport;
        this.house = house;

    }


    /**
     * Конструктор для создания объекта {@link Flat} с текущей датой создания.
     *
     * @param id            Уникальный идентификатор квартиры (должен быть больше 0).
     * @param name          Название квартиры (не может быть пустым).
     * @param coordinates   Координаты квартиры.
     * @param area          Площадь квартиры (должна быть больше 0).
     * @param numberOfRooms Количество комнат (должно быть больше 0).
     * @param furnish       Тип отделки квартиры.
     * @param view          Вид из окна квартиры.
     * @param transport     Тип транспорта вблизи квартиры.
     * @param house         Дом, в котором находится квартира.
     */
    public Flat(Long id, String name, Coordinates coordinates, long area, long numberOfRooms, Furnish furnish, View view, Transport transport, House house) {
        this(id, name, coordinates, LocalDateTime.now(), area, numberOfRooms, furnish, view, transport, house);
    }

    /**
     * Переопределенный метод {@code toString}, который возвращает строковое представление объекта {@link Flat}.
     *
     * @return Строковое представление объекта {@link Flat}.
     */
    @Override
    public String toString() {
        return "{id: " + id + ", name: " + name + ", coordinates: "
                + coordinates.toString() + ", creationDate: " + creationDate.toString()
                + ", area: " + area + ", numberOfRooms: " + numberOfRooms + ", furnish: "
                + furnish + ", view: " + view + ", transport: " + transport
                + ", house: " + house + "}";

    }

    public Long getArea() {
        return area;
    }

    public Long getNumbersOfRooms() {
        return numberOfRooms;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Furnish getFurnish() {
        return furnish;
    }

    public View getView() {
        return view;
    }

    /**
     * Метод для сравнения двух объектов {@link Flat} по площади и количеству комнат.
     *
     * @param flat Объект {@link Flat}, с которым будет производиться сравнение.
     * @return Результат сравнения:
     *         - Отрицательное значение, если текущий объект меньше переданного.
     *         - Положительное значение, если текущий объект больше переданного.
     *         - Ноль, если объекты равны.
     */
    @Override
    public int compareTo(Flat flat) {
        int result = Long.compare(this.area, flat.getArea());
        if (result == 0) {
            result = Long.compare(this.numberOfRooms, flat.getNumbersOfRooms());
        }
        return result;
    }

    /**
     * Метод для валидации данных объекта {@link Flat}.
     * <p>
     * Проверяется, что все поля объекта имеют правильные значения:
     * - id не null и больше 0
     * - name не null и не пустой
     * - coordinates не null и валидны
     * - creationDate не null
     * - area и numberOfRooms больше 0
     * - furnish, view, transport и house не null и валидны.
     * </p>
     *
     * @return {@code true}, если все поля валидны, иначе {@code false}.
     */
    @Override
    public boolean validate() {
        boolean res = (id != null) && (id > 0)  && (name != null) && (!name.isEmpty()) && (coordinates != null)
                && (creationDate != null) && (area > 0) && (numberOfRooms > 0) && (furnish != null) && (view != null)
                && (transport != null) && (house != null) && (coordinates.validate()) && (house.validate());
        return res;

    }
}

