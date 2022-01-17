package ru.edu.model;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class XmlRegistryTest {

    @Test
    public void readFrom() {
        XmlRegistry xmlRegistry= new XmlRegistry();
        Registry registry;
        try {
            registry = xmlRegistry.readFrom("./input/cd_catalog.xml/").convertToRegistry();

            for (Country co: registry.getCountries()
                 ){System.out.println(co.getName() +" "+  co.getArtists() );
                for (Artist ar:
                        co.getArtists()) {
                    System.out.println(ar.getName() +" "+  ar.getAlbums() );
                    for(Album al: ar.getAlbums()){


                System.out.println(al.getName() +" "+  al.getYear());

            }}}
            int i = 0;
            for (CD cd:xmlRegistry.readFrom("./input/cd_catalog.xml/").getCdList()
            ) {System.out.println(xmlRegistry.readFrom("./input/cd_catalog.xml/").getCdList() .get(i).getArtist() + ", " + xmlRegistry.readFrom("./input/cd_catalog.xml/").getCdList().get(i).getTitle() +
                    ", " + xmlRegistry.readFrom("./input/cd_catalog.xml/").getCdList().get(i).getCountry() + " "+ xmlRegistry.readFrom("./input/cd_catalog.xml/").getCdList().get(i).getYear()+" "
                    + xmlRegistry.readFrom("./input/cd_catalog.xml/").getCdList().get(i).getTitle());

                i++;

            }

            xmlRegistry.writeTo("./output/artist_by_country.xml",registry);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void writeTo() {
    }
}