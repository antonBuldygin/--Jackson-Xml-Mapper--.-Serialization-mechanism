package ru.edu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.edu.model.Catalog;

import java.io.*;

public class MapperUtils {
    public static <T> T readJson(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
     return  mapper.readValue(new File(fileName), clazz);

    }

    public static void mapJson(String fileName, Object obj) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(fileName), obj);

    }

    public static <T> T readXml(String fileName, Class<T> clazz) throws IOException {
        XmlMapper mapper = new XmlMapper();
        return  mapper.readValue(new File(fileName), clazz);

    }

    public static void mapXml(String fileName, Object obj) throws IOException {

        XmlMapper mapper = new XmlMapper();
        mapper.writeValue(new File(fileName), obj);

    }

    public static <T> T readJava(String fileName, Class<T> clazz) throws Exception {
        ObjectInputStream inputStream = new ObjectInputStream( new FileInputStream(fileName));

        return  (T) inputStream.readObject();

    }

    public static void mapJava(String fileName, Object obj) throws IOException {

        ObjectOutputStream outputStream =  new ObjectOutputStream(new FileOutputStream(
                fileName));
            outputStream.writeObject(obj);

    }
}
