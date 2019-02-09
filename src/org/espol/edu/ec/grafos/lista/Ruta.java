/*
 * The MIT License
 *
 * Copyright 2017 cliente.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.espol.edu.ec.grafos.lista;

/**
 *
 * @author cliente
 */
public class Ruta {
    private final String Airline;
    private final int Airline_ID;
    private final String Source_airport;
    private final int Source_airport_ID;
    private final String Destination_airport;
    private final int Destination_airport_ID;
    private final String Codeshare;
    private final int Stops;
    private final String Equipment;

    public Ruta(String Airline, int Airline_ID, String Source_airport, int Source_airport_ID, String Destination_airport, int Destination_airport_ID, String Codeshare, int Stops, String Equipment) {
        this.Airline = Airline;
        this.Airline_ID = Airline_ID;
        this.Source_airport = Source_airport;
        this.Source_airport_ID = Source_airport_ID;
        this.Destination_airport = Destination_airport;
        this.Destination_airport_ID = Destination_airport_ID;
        this.Codeshare = Codeshare;
        this.Stops = Stops;
        this.Equipment = Equipment;
    }

    public String getSource_airport() {
        return Source_airport;
    }

    public String getDestination_airport() {
        return Destination_airport;
    }

    
}
