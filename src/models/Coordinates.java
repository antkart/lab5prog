package models;

/**
 * Класс, представляющий координаты с двумя полями: x и y.
 * <p>
 * Класс реализует интерфейс {@link Validatable}, что позволяет проводить валидацию данных.
 * Поле {@code x} должно быть больше -150, поле {@code y} может иметь любое значение.
 * </p>
 */
public class Coordinates implements Validatable {
    private Integer x; //Значение поля должно быть больше -150, Поле не может быть null
    private float y;

    /**
     * Конструктор для создания объекта {@link Coordinates}.
     *
     * @param x Значение координаты по оси X, должно быть больше -150.
     * @param y Значение координаты по оси Y.
     */
    public Coordinates(Integer x, float y){
        this.x = x;
        this.y = y;
    }

    /**
     * Метод для валидации координат.
     * <p>
     * Этот метод проверяет, что значение x больше -150.
     * </p>
     *
     * @return true, если координаты действительны (x > -150), иначе false.
     */
    @Override
    public boolean validate() {
        boolean res = x > -150;
        return res;
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y + ")";
    }
}
