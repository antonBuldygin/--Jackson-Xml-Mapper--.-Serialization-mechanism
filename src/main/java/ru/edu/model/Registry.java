package ru.edu.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "ArtistRegistry")
public class Registry implements Serializable {
    private static final long serialVersionUID = 6L;

    /**
     * to set list of counties.
     * @param countriees
     */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Country")
    public void setCountries(final List<Country> countriees) {
        countries = countriees;
    }

    /**
     * creates
     * new list of counties.
     */

    private List<Country> countries = new ArrayList<>();

    /**
     * to get list of countries.
     * @return countries
     */
    public List<Country> getCountries() {
        return countries;
    }

    /**
     * to add country
     * to the list of countries.
     * @param country
     */
    public void addCountry(final Country country) {

      countries.add(country);

    }

    /**
     * return qualtity of
     * countries in the registry.
     * @return countries.size()
     */
    @JacksonXmlProperty(localName = "countryCount", isAttribute = true)

    public int getCountryCount() {

        return countries.size();

    }
}
