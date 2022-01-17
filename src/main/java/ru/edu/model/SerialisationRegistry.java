package ru.edu.model;

import ru.edu.RegistryExternalStorage;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.io.ObjectInputStream;


public class SerialisationRegistry implements RegistryExternalStorage {


    /**
     * Чтение из файла.
     *
     * @param filePath путь до файла
     * @return
     */
    @Override
    public Catalog readFrom(final String filePath)
            throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream(
                        (filePath)));

        try {
            inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (Catalog) inputStream.readObject();
    }

    /**
     * Запись реестра в файл.
     *
     * @param filePath путь
     * @param registry реестр
     */

    @Override
    public void writeTo(final String filePath, final Registry registry)
            throws FileNotFoundException {

        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(
                    filePath));
            outputStream.writeObject(registry);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
