package ru.edu.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class RegistryTest {

    @Test
    public void getCountries() throws Exception {
        Registry registry = new Registry();
        fillCounties(registry.getCountries());

        ObjectMapper mapper=new ObjectMapper();
        try(FileOutputStream fous=new FileOutputStream("./output/artist_by_country.json");) {

            mapper.writeValue(fous,registry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillCounties(List<Country> countries) {
        for (int i = 0; i < 3; i++) {

            Country country = new Country("country" + i);
            fillArtist(country.getArtists());
            countries.add(country);

        }
    }

    private void fillArtist(List<Artist> artists) {
        for (int i = 0; i < 3; i++) {

            artists.add(new Artist("Artist" + i));


        }
    }


}