package ru.edu.model;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.edu.RegistryExternalStorage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XmlRegistry implements RegistryExternalStorage {
    /**
     * Чтение из файла.
     *
     * @param filePath путь до файла
     */
    @Override
    public Catalog readFrom(final String filePath)
            throws IOException, ClassNotFoundException {
        XmlMapper mapper = new XmlMapper();
        mapper.configure(DeserializationFeature
                .FAIL_ON_UNKNOWN_PROPERTIES, false);
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
        XmlMapper mapper = new XmlMapper();
        FileOutputStream fous = new FileOutputStream(filePath);
        mapper.writeValue(fous, registry);
    }
}
