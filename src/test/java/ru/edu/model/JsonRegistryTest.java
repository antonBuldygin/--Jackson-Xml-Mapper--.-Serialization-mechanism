package ru.edu.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class JsonRegistryTest {

    @Test
    public void readFrom() {
        JsonRegistry jsonRegistry= new JsonRegistry();
        XmlRegistry xmlRegistry= new XmlRegistry();
        Registry registry;
        try {
            Catalog catalog = xmlRegistry.readFrom("./input/cd_catalog.xml/");
            registry=catalog.convertToRegistry( );
            jsonRegistry.writeTo("./output/artist_by_country.json/",registry);
          catalog = jsonRegistry.readFrom("./output/artist_by_country.json/");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void writeTo() {
    }
}