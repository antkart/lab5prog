package managers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Flat;
import models.Coordinates;
import models.Furnish;
import models.View;
import models.Transport;
import models.House;
import managers.LocalDateTimeAdapter;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.io.FileInputStream;
/**
 * Класс {@code DumpManager} отвечает за чтение и запись коллекции объектов {@code Flat}
 * из и в файл. Использует ручной парсинг JSON-подобной структуры, а также библиотеку GSON
 * для сериализации и десериализации.
 * <p>
 * Обеспечивает сохранение данных между сессиями приложения.
 */

public class DumpManager {

    /**
     * Считывает коллекцию объектов {@code Flat} из файла.
     *
     * @param fileName путь к файлу с данными
     * @return коллекция {@code Set<Flat>}, считанная из файла
     */
    public static Set<Flat> readCollection(String fileName) {
        if (fileName != null && !fileName.isEmpty()) {
            Set<Flat> flats = new LinkedHashSet<>();
            try {
                BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
                HashMap<String, ArrayList<String>> help = new HashMap<>();
                String fieldName = "";
                String value = "";
                int ch;
                int countName = 0;
                char current;
                while ((ch = buf.read()) != -1) {
                    current = (char) ch;
                    if (current == '\"') {
                        while ((ch = buf.read()) != '\"') {
                            fieldName += Character.toString((char) ch);
                        }
                        while ((ch = buf.read()) != ':') {

                        }
                        value = parseValue(buf.readLine());
                    }
                    if (!fieldName.isEmpty() && !fieldName.equals("coordinates") && !fieldName.equals("house")) {
                        if (help.get(fieldName) == null) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            arrayList.add(value);
                            help.put(fieldName, arrayList);
                        } else {
                            if (fieldName.equals("name")) {
                                countName += 1;
                                if (countName % 2 != 0) {
                                    if (help.get("name2") == null) {
                                        ArrayList<String> arList = new ArrayList<>();
                                        arList.add(value);
                                        help.put("name2", arList);
                                    } else {
                                        ArrayList<String> arList = help.get("name2");
                                        arList.add(value);
                                        help.put("name2", arList);
                                    }
                                } else {
                                    ArrayList<String> list = help.get(fieldName);
                                    list.add(value);
                                    help.put(fieldName, list);
                                }
                            } else {
                                ArrayList<String> list = help.get(fieldName);
                                list.add(value);
                                help.put(fieldName, list);
                            }
                        }
                    }
                    value = "";
                    fieldName = "";
                }

                for (int i = 0; i < help.get("id").size(); ++i) {
                    Transport transport;
                    View view;
                    Furnish furnish;
                    long id = Long.parseLong(help.get("id").get(i));
                    String name = help.get("name").get(i);
                    int x = Integer.parseInt(help.get("x").get(i));
                    int y = Integer.parseInt(help.get("y").get(i));
                    LocalDateTime creationDate = LocalDateTime.parse(help.get("creationDate").get(i));
                    long area = Long.parseLong(help.get("area").get(i));
                    long numberOfRooms = Long.parseLong(help.get("numberOfRooms").get(i));

                    if (help.get("furnish").get(i) != null) {
                        furnish = Furnish.valueOf(help.get("furnish").get(i));
                    } else {
                        furnish = null;
                    }

                    if (help.get("view").get(i) != null) {
                        view = View.valueOf(help.get("view").get(i));
                    } else {
                        view = null;
                    }

                    if (help.get("transport").get(i) != null) {
                        transport = Transport.valueOf(help.get("transport").get(i));
                    } else {
                        transport = null;
                    }

                    String name2 = help.get("name2").get(i);
                    int year = Integer.parseInt(help.get("year").get(i));
                    long numberOfFlatsOnFloor = Long.parseLong(help.get("numberOfFlatsOnFloor").get(i));

                    Flat flat = new Flat(id, name, new Coordinates(x, y), creationDate, area, numberOfRooms, furnish, view, transport, new House(name2, year, numberOfFlatsOnFloor));
                    flats.add(flat);
                }
                return flats;
            } catch (FileNotFoundException e) {
                System.out.println("Загрузочный файл не найден");
            } catch (NoSuchElementException e) {
                System.out.println("Загрузочный файл пуст");
            } catch (IllegalStateException | IOException e) {
                System.out.println("Что то пошло не так");
                System.exit(0);
            }
        } else {
            System.out.println("Загрузочный файл не найден");
        }


        return new LinkedHashSet<Flat>();
    }

    /**
     * Извлекает значение из строки, определяя его тип: строка, число или null.
     *
     * @param line строка, содержащая значение
     * @return извлечённое значение в виде строки или {@code null}
     */
    public static String parseValue(String line) {
        String valueString;
        String valueInt;
        if (line.contains("\"")) {
            valueString = parseValueString(line);
            return valueString;
        } else if (line.contains("null")) {
            return null;
        } else {
            valueInt = parseValueInt(line);
            return valueInt;
        }

    }

    /**
     * Извлекает строковое значение из строки вида: "ключ": "значение".
     *
     * @param line строка для обработки
     * @return строковое значение
     */
    public static String parseValueString(String line) {
        char[] trash = line.toCharArray();
        int count = 0;
        String value = "";
        for (char c : trash) {
            if (c == '\"') {
                count += 1;
                continue;
            }
            if (count == 1) {
                value += Character.toString(c);
            }
            if (count == 2) {
                break;
            }
        }
        return value;
    }

    /**
     * Извлекает числовое значение из строки, пропуская лишние символы.
     *
     * @param line строка, содержащая числовое значение
     * @return числовое значение в виде строки
     */
    public static String parseValueInt(String line) {
        char[] trash = line.toCharArray();
        String value = "";
        for (char c : trash) {
            if (Character.isDigit(c) || c == '-') {
                value += Character.toString(c);
            }
        }
        return value;
    }


    /**
     * Сохраняет коллекцию {@code Flat} в указанный файл в формате JSON с использованием GSON.
     *
     * @param collection коллекция объектов {@code Flat}, которую нужно сохранить
     * @param fileName   путь к файлу, куда будет произведена запись
     */
    public static void writeCollection(Set<Flat> collection, String fileName) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(collection, writer);
            System.out.println("Коллекция записана в " + fileName);
        } catch (IOException e) {
            System.out.println("Файл не может быть открыт");;
        }
    }


}
