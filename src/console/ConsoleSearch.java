package console;

import models.*;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Класс, предоставляющий методы для поиска значений различных полей
 * объекта {@link Flat} через консольный ввод.
 */
public class ConsoleSearch {

    /**
     * Запрашивает все необходимые данные для создания объекта {@link Flat}
     * через консольный ввод.
     *
     * @param buf {@link BufferedReader} для чтения ввода
     * @param id идентификатор объекта {@link Flat}
     * @return новый объект {@link Flat} с заполненными данными
     * @throws IOException если возникает ошибка при чтении ввода
     */
    public static Flat searchFlat(BufferedReader buf, long id) throws IOException {
        String name = searchName(buf);
        Coordinates coordinates = searchCoordinates(buf);
        long area = searchArea(buf);
        long numberOfRooms = searchNumberOfRooms(buf);
        Furnish furnish = searchFurnish(buf);
        View view = searchView(buf);
        Transport transport = searchTransport(buf);
        House house = searchHouse(buf);
        Flat flat = new Flat(id, name, coordinates, area, numberOfRooms, furnish, view, transport, house);
        return flat;
    }

    /**
     * Запрашивает координаты (x и y) объекта {@link Coordinates} через консольный ввод.
     *
     * @param buf {@link BufferedReader} для чтения ввода
     * @return новый объект {@link Coordinates} с заданными значениями
     * @throws IOException если возникает ошибка при чтении ввода
     */
    public static Coordinates searchCoordinates(BufferedReader buf) throws IOException {
        Coordinates coordinates;
        String valueX;
        String valueY;
        int x;
        float y;
        Console console = new ConsoleMain();
        while (true) {
            console.print("coordinates.x: ");
            valueX = console.readln(buf);
            if (!valueX.isEmpty()) {
                try {
                    x = Integer.parseInt(valueX);
                    if (x <= -150) {
                        System.out.println("Введите число большее -150");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат ввода, введите целое число большее -150");
                }
            } else {
                System.out.println("Значение не может быть null");
            }
        }
        while (true) {
            console.print("coordinates.y: ");
            valueY = console.readln(buf);
            if (!valueY.isEmpty()) {
                try {
                    y = Float.parseFloat(valueY);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Введите число");
                }
            } else {
                System.out.println("Значение не может быть null");
            }
        }

        coordinates = new Coordinates(x, y);
        return coordinates;


    }


    /**
     * Запрашивает area объекта {@link Flat} через консольный ввод.
     *
     * @param buf {@link BufferedReader} для чтения ввода
     * @return площадь в виде числа типа long
     * @throws IOException если возникает ошибка при чтении ввода
     */
    public static long searchArea(BufferedReader buf) throws IOException {
        String valueArea;
        long area;
        Console console = new ConsoleMain();
        while (true) {
            console.print("area: ");
            valueArea = console.readln(buf);
            if (!valueArea.isEmpty()) {
                try {
                    area = Long.parseLong(valueArea);
                    if (area <= 0) {
                        System.out.println("Введите число большее 0");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Введите натуральное число");
                }
            } else {
                System.out.println("Значение не может быть null");
            }
        }
        return area;
    }

    /**
     * Запрашивает numberOfRooms в объекте {@link Flat} через консольный ввод.
     *
     * @param buf {@link BufferedReader} для чтения ввода
     * @return количество комнат в виде числа типа long
     * @throws IOException если возникает ошибка при чтении ввода
     */
    public static long searchNumberOfRooms(BufferedReader buf) throws IOException {
        long numberOfRooms;
        String value;
        Console console = new ConsoleMain();
        while (true) {
            console.print("numberOfRooms: ");
            value = console.readln(buf);
            if (!value.isEmpty()) {
                try {
                    numberOfRooms = Long.parseLong(value);
                    if (numberOfRooms <= 0) {
                        System.out.println("Введите целое число большее 0");
                    } else {
                        break;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Введите натуральное число");
                }
            } else {
                System.out.println("Значение не может быть null");
            }
        }
        return numberOfRooms;
    }

    /**
     * Запрашивает Furnish объекта {@link Furnish} через консольный ввод.
     *
     * @param buf {@link BufferedReader} для чтения ввода
     * @return объект {@link Furnish} с выбранным значением
     * @throws IOException если возникает ошибка при чтении ввода
     */
    public static Furnish searchFurnish(BufferedReader buf) throws IOException {
        String value;
        Console console = new ConsoleMain();
        Furnish furnish;
        while (true) {
            console.print("furnish: ");
            value = console.readln(buf);
            if (!value.isEmpty()) {
                try {
                    furnish = Furnish.valueOf(value);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка! Выберите значение из списка [DESIGNER, NONE, FINE, BAD]");
                }
            } else {
                System.out.println("Значение не может быть null");
            }

        }
        return furnish;
    }

    /**
     * Запрашивает View объекта {@link View} через консольный ввод.
     *
     * @param buf {@link BufferedReader} для чтения ввода
     * @return объект {@link View} с выбранным значением
     * @throws IOException если возникает ошибка при чтении ввода
     */
    public static View searchView(BufferedReader buf) throws IOException {
        String value;
        View view;
        Console console = new ConsoleMain();
        while (true) {
            console.print("view: ");
            value = console.readln(buf);
            if (!value.isEmpty()) {
                try {
                    view = View.valueOf(value);
                    break;
                } catch(IllegalArgumentException e) {
                    System.out.println("Ошибка! Выберите значение из списка [STREET, BAD, GOOD]");
                }
            } else {
                System.out.println("Значение не может быть null");
            }
        }
        return view;

    }

    /**
     * Запрашивает Transport объекта {@link Transport} через консольный ввод.
     *
     * @param buf {@link BufferedReader} для чтения ввода
     * @return объект {@link Transport} с выбранным значением
     * @throws IOException если возникает ошибка при чтении ввода
     */
    public static Transport searchTransport(BufferedReader buf) throws IOException {
        Transport transport;
        Console console = new ConsoleMain();
        String value;
        while (true) {
            console.print("trasport: ");
            value = console.readln(buf);
            if (!value.isEmpty()) {
                try {
                    transport = Transport.valueOf(value);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка! Выберите значение из списка [FEW, LITTLE, NORMAL, ENOUGH]");
                }
            } else {
                transport = null;
                break;
            }
        }
        return transport;
    }

    /**
     * Запрашивает House объекта {@link House} через консольный ввод.
     *
     * @param buf {@link BufferedReader} для чтения ввода
     * @return объект {@link House} с выбранными значениями
     * @throws IOException если возникает ошибка при чтении ввода
     */
    public static House searchHouse(BufferedReader buf) throws IOException {
        House house;
        Console console = new ConsoleMain();
        String line;
        String name;
        int year;
        long numberOfFlatsOnFloor;
        while (true) {
            console.print("house.name: ");
            name = console.readln(buf);
            if (!name.isEmpty()) {
                break;
            } else {
                name = null;
                break;
            }
        }

        while (true) {
            console.print("house.year: ");
            line = console.readln(buf);
            if (!line.isEmpty()) {
                try {
                    year = Integer.parseInt(line);
                    if (year <=  0) {
                        System.out.println("Введите положительное число");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Введите натуральное число");
                }
            } else {
                System.out.println("Значение не может быть null");
            }
        }

        while (true) {
            console.print("house.numberOfFlatsOnFloor: ");
            line = console.readln(buf);
            if (!line.isEmpty()) {
                try {
                    numberOfFlatsOnFloor = Long.parseLong(line);
                    if (numberOfFlatsOnFloor <= 0) {
                        System.out.println("Введите натуральное число большее 0");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Введите натуральное число");
                }
            } else {
                System.out.println("Значение не может быть null");
            }
        }
        house = new House(name, year, numberOfFlatsOnFloor);
        return house;
    }

    /**
     * Запрашивает name объекта {@link Flat} через консольный ввод.
     *
     * @param buf {@link BufferedReader} для чтения ввода
     * @return строка с именем
     * @throws IOException если возникает ошибка при чтении ввода
     */
    public static String searchName(BufferedReader buf) throws IOException {
        String name;
        Console console = new ConsoleMain();
        while (true) {
            console.print("name: ");
            name = console.readln(buf);
            if (!name.isEmpty()) {
                break;
            } else {
                System.out.println("Значение не может быть null");
            }
        }
        return name;
    }

}
