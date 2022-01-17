package ru.edu.model;



import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


public class Artist implements Serializable {
    private static final long serialVersionUID = 2L;

    /**
     * имя исполнителя.
     */
    @JacksonXmlProperty(localName = "Name")
    private String name;

    /**
     * созданик коллекции
     * альбомов исполнителя.
     */
    @JacksonXmlElementWrapper(localName = "Albums")
    @JacksonXmlProperty(localName = "Album")
    private List<Album> albums = new ArrayList<>();

    /**
     * конструктор
     * исполнителя.
     * @param nameOfArtist
     */
    public Artist(final String nameOfArtist) {
        this.name = nameOfArtist;
    }

    /**
     * пустой конструктор.
     */

    public Artist() {
    }

    /**
     * Возвращает имя
     * исполнителя.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * добавляет альбом
     * в коллекцию.
     * @param album
     */
    public void addAlbum(final Album album) {

        this.albums.add(album);

    }

    /**
     * to get list of albums.
     * @return albums
     */
    public List<Album> getAlbums() {

        return albums;

    }
}
