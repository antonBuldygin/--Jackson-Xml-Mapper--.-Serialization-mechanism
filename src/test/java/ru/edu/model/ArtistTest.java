package ru.edu.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;
import ru.edu.MapperUtils;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class ArtistTest {

    @Test
    public void jSonTest() throws IOException {
        Artist artist=new Artist("Artist0");
        MapperUtils.mapJson("./src/test/resources/artist.json",artist);
         artist = MapperUtils.readJson("./src/test/resources/artist.json", Artist.class);
        String jsonString = new ObjectMapper().writeValueAsString(artist);
assertEquals( "{\"name\":\"Artist0\",\"albums\":[]}", jsonString);

        assertEquals("Artist0", artist.getName());
    }

    @Test
    public void xMlTest() throws IOException {
        Artist artist=new Artist("Artist0");
        MapperUtils.mapXml("./src/test/resources/artist.xml",artist);
        artist = MapperUtils.readXml("./src/test/resources/artist.xml", Artist.class);
        String xmlString = new XmlMapper().writeValueAsString(artist);
        assertEquals( "<Artist><Name>Artist0</Name><Albums/></Artist>", xmlString);

        assertEquals("Artist0", artist.getName());
    }

    @Test
    public void javaTest() throws Exception {
        Artist artist=new Artist("Artist0");
        MapperUtils.mapJava("./src/test/resources/artist.serialized",artist);
        Artist artist1= MapperUtils.readJava("./src/test/resources/artist.serialized", Artist.class);

        assertEquals( artist1.getName(), artist.getName());

        assertEquals(artist1.getAlbums(), artist.getAlbums());
    }
}

