package ru.edu.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@JacksonXmlRootElement(localName = "CATALOG")
public class Catalog implements Serializable {
    private static final long serialVersionUID = 3L;



    /**
     * создает
     * коллекцию CD.
     */

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "CD")
    private List<CD> cdList = new ArrayList<>();

    /**
     * пустой конструктор.
     */
    public Catalog() {
    }

    /**
     * констркутор с параметром.
     * @param cdsList
     */
    public Catalog(final List<CD> cdsList) {
        this.cdList = cdsList;
    }

    /**
     * возвращает коллекию CD.
     * @return cdList
     */
    public List<CD> getCdList() {
        return cdList;
    }

    /**создает
     * реестр исполнителей
     * по странам.
     * @return registry.
     */
    public Registry convertToRegistry() {
        Map<String, List<CD>> countryMap = cdList.stream()

                .collect(Collectors.groupingBy(CD::getCountry));
        Registry registry = new Registry();
        countryMap.forEach((country, listOfArtists) -> {
            Country countryObj = new Country(country);
            registry.addCountry(countryObj);
            Map<String, List<CD>> artistsMap = listOfArtists
                    .stream().collect(Collectors.groupingBy(CD::getArtist));
            artistsMap.forEach((artist, listOfAlbums) -> {
                Artist artistObj = new Artist(artist);
                countryObj.addArtist(artistObj);
                listOfAlbums.forEach(cd ->
                        artistObj.addAlbum(
                                new Album(cd.getTitle(), cd.getYear())
                        )
                );
            });
        });

        return registry;
    }
}
