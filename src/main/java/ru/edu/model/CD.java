package ru.edu.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;

public class CD implements Serializable {
    private static final long serialVersionUID = 4L;

    /**
     * конструктор CD.
     */
    public CD() {
    }

    /**
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * название CD.
     */
    @JacksonXmlProperty(localName = "TITLE")
    private String title;

    /**
     * Возвращает
     * имя исполнителя.
     * @return artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * artist name.
     */
    @JacksonXmlProperty(localName = "ARTIST")
    private String artist;

    /**
     * artist country.
     */
    @JacksonXmlProperty(localName = "COUNTRY")
    private String country;

    /**
     * company
     * CD producer.
     */
    @JacksonXmlProperty(localName = "COMPANY")
    private  String company;

    /**
     * CD price.
     */
    @JacksonXmlProperty(localName = "PRICE")
    private Double price;

    /**
     * to get CD year .
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * CD year.
     */
    @JacksonXmlProperty(localName = "YEAR")
    private int year;

    /**
     * to get CD country.
     * @return country
     */
    public String getCountry() {
        return country;
    }
}
