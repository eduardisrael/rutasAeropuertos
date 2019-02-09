/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.espol.edu.ec.grafos.lista;

/**
 *
 * @author cliente
 */
public class Aeropuerto {
    private final String Airport_ID;
    private final String Name;
    private final String City;
    private final String Country;
    private final String IATA_FAA;
    private final String ICAO;
    private final Double Latitude;
    private final Double Longitude;
    private final int Altitude;
    private final Double Timezone;
    private final String DST;

    public Aeropuerto(String Airport_ID, String Name, String City, String Country, String IATA_FAA, String ICAO, Double Latitude, Double Longitude, int Altitude, Double Timezone, String DST) {
        this.Airport_ID = Airport_ID;
        this.Name = Name;
        this.City = City;
        this.Country = Country;
        this.IATA_FAA = IATA_FAA;
        this.ICAO = ICAO;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
        this.Altitude = Altitude;
        this.Timezone = Timezone;
        this.DST = DST;
    }

    @Override
    public String toString() {
        return "Aeropuerto{" + "Airport_ID=" + Airport_ID + ", Name=" + Name + ", City=" + City + ", Country=" + Country + ", IATA_FAA=" + IATA_FAA + ", ICAO=" + ICAO + ", Latitude=" + Latitude + ", Longitude=" + Longitude + ", Altitude=" + Altitude + ", Timezone=" + Timezone + ", DST=" + DST + '}';
    }

    public String getName() {
        return Name;
    }

    public String getIATA_FAA() {
        return IATA_FAA;
    }

    public String getCountry() {
        return Country;
    }

    public String getICAO() {
        return ICAO;
    }
    
    
    
}
