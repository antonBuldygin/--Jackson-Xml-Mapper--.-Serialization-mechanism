package ru.edu;

import ru.edu.model.Registry;

/**
 * Примерный интерфейс для сериализации/десериализации реестра.
 * Под каждый формат XML, JSON, java serialization должна быть отдельная реализация.
 *
 * Ограничений на архитектуру нет, интерфейс можно менять как угодно или полностью от него отказаться,
 * но не забываем стараться соответствовать чистой архитектуре и следование принципам SOLID, DRY, KISS и т.д.
 */
public interface RegistryExternalStorage {

    /**
     * Чтение из файла.
     *
     * @param filePath путь до файла
     */
    void readFrom(String filePath);

    /**
     * Запись реестра в файл.
     *
     * @param filePath путь
     * @param registry реестр
     */
    void writeTo(String filePath, Registry registry);
}
