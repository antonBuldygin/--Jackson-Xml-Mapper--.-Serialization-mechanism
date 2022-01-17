package ru.edu.model;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class SerialisationRegistryTest {

    @Test
    public void readFrom() {
       SerialisationRegistry serialisationRegistry = new SerialisationRegistry();
        XmlRegistry xmlRegistry = new XmlRegistry();
        Registry registry;

        Catalog catalog = null;
        try {
            catalog = xmlRegistry.readFrom("./input/cd_catalog.xml/");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        registry = catalog.convertToRegistry();
        try {
            serialisationRegistry.writeTo("./output/artist_by_country.serialized/", registry);
           catalog= serialisationRegistry.readFrom("./output/artist_by_country.serialized/");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void writeTo() {
    }
}