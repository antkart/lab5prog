package managers;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import models.*;
/**
 * Адаптер для сериализации и десериализации объектов {@link LocalDateTime}
 * при использовании библиотеки Gson.
 * <p>
 * Форматируется согласно {@code ISO_LOCAL_DATE_TIME}.
 * Используется при сохранении и загрузке коллекции в JSON.
 */
public class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    /**
     * Сериализует объект {@code LocalDateTime} в {@code JsonElement}.
     *
     * @param date объект {@code LocalDateTime} для сериализации
     * @param typeOfSrc тип сериализуемого объекта
     * @param context контекст сериализации
     * @return JSON-представление даты
     */
    @Override
    public JsonElement serialize(LocalDateTime date, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(date.format(formatter));
    }

    /**
     * Десериализует {@code JsonElement} в объект {@code LocalDateTime}.
     *
     * @param json JSON-представление даты
     * @param typeOfT тип возвращаемого объекта
     * @param context контекст десериализации
     * @return десериализованный объект {@code LocalDateTime}
     * @throws JsonParseException если не удалось распарсить строку
     */
    @Override
    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return LocalDateTime.parse(json.getAsString(), formatter);
    }
}
