package ru.edu.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Country implements Serializable {
    private static final long serialVersionUID = 5L;

    /**
     * Country name.
     */
    private String name;

    /**
     * list of Artists.
     */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Artist")
    private List<Artist> artists = new ArrayList<>();

    /**
     * Constructor.
     * @param nam
     */
    public Country(final String nam) {
        this.name = nam;
    }

    /**
     * default constructor.
     */
    public Country() {
    }

    /**
     * to get country name.
     * @return name
     */
    @JacksonXmlProperty(localName = "name", isAttribute = true)
    public String getName() {
        return name;
    }

    /**
     * to get list of Artists.
     * @return artists
     */
    public List<Artist> getArtists() {
        return artists;
    }

    /**
     * to add Artist to list of artists.
     * @param artist
     */
    public void addArtist(final Artist artist) {

        this.artists.add(artist);

    }
}
