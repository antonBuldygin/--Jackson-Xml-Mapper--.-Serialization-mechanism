package ru.edu.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import ru.edu.RegistryExternalStorage;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class JsonRegistry implements RegistryExternalStorage {
    /**
     * Чтение из файла.
     *
     * @param filePath путь до файла
     */
    @Override
    public Catalog readFrom(final String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        FileInputStream fis = new FileInputStream(filePath);
        return mapper.readValue(fis, Catalog.class);
    }

    /**
     * Запись реестра в файл.
     *
     * @param filePath путь
     * @param registry реестр
     */
    @Override
    public void writeTo(final String filePath,
                        final Registry registry) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        FileOutputStream fous = new FileOutputStream(filePath);
        mapper.writeValue(fous, registry);
    }
}
