/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.espol.edu.ec.grafos.lista;

/**
 *
 * @author ancalder
 */
public interface TDAGrafo<T> {
    /**
     * Adds a vertex to this graph, associating object with vertex.
     */
    public void agregarVertice(T elem);

    /**
     * Removes a single vertex with the given value from this graph.
     */
    public void removerVertice(T elem);

    /**
     * Inserts an edge between two vertices of this graph.
     */
    public void agregarArco(T elem1, T elem2);

    /**
     * Removes an edge between two vertices of this graph.
     */
    public void removerArco(T elem1, T elem2);
    
    public Vertice<T> buscarVertice(T elem);
    public void resetearVisitados();
    
}
