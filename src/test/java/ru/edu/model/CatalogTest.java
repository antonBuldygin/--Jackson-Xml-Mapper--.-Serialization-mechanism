package ru.edu.model;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CatalogTest extends TestCase {

    private ObjectMapper mapper;

    @Test
    public void test() {
        XmlMapper mapper = new XmlMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Catalog catalog = null;
        try (FileInputStream fis = new FileInputStream("./input/cd_catalog.xml/")) {

            catalog = mapper.readValue(fis, Catalog.class);

            assertNotNull(catalog);
        } catch (Exception e) {
            e.printStackTrace();
        }

        exampleStreams(catalog,false);

    }

    private void exampleStreams(Catalog catalog, boolean isFilter) {
        Stream<CD> stream = catalog.getCdList().stream();

        if(isFilter){

            stream=stream.filter((cd -> cd.getArtist().startsWith("A")));
        }
        mapper = new ObjectMapper();

        List<Album> albums = stream
                .map(cd -> new Album(cd.getArtist(), cd.getYear()))
                .collect(Collectors.toList());

        Stream<CD> collect = catalog.getCdList().stream();

        Map<String , List<Album>> groupByCountry= new TreeMap(collect.collect(Collectors.groupingBy(CD::getCountry)));
    }
 }