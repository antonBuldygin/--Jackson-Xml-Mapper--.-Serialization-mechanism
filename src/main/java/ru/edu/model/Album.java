package ru.edu.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;

public class Album implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Возвращает название Альбома.
     *
     * @return name
     */
    @JacksonXmlProperty(localName = "name", isAttribute = true)
    public String getName() {
        return name;
    }

    /**
     * год выпуска.
     *
     * @return year
     */
    @JacksonXmlProperty(localName = "year", isAttribute = true)
    public int getYear() {
        return year;
    }

    /**
     * контруктор.
     *
     * @param artist
     * @param year1
     * @return
     */
    public Album(final String artist, final int year1) {
        name = artist;
        year = year1;
    }

    /**
     * default constructor.
     */
    public Album() {
    }

    /**
     * название Альбома.
     */
    @JacksonXmlProperty(localName = "name", isAttribute = true)
    private String name;
    /**
     * параметр гож выпуска Альбома.
     */
    @JacksonXmlProperty(localName = "year", isAttribute = true)
    private int year;
}
