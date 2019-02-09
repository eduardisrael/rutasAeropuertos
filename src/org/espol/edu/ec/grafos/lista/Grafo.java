/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.espol.edu.ec.grafos.lista;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;



/**
 *
 * @author ancalder
 */
public class Grafo<T> implements TDAGrafo<T> {

    private LinkedList<Vertice<T>> vertices;
    private boolean dirigido;

    public Grafo(boolean dirigido) {
        this.dirigido = dirigido;
        this.vertices = new LinkedList<>();
    }

    public LinkedList<Vertice<T>> getVertices() {
        return vertices;
    }

    public boolean isDirigido() {
        return dirigido;
    }

    public void setVertices(LinkedList<Vertice<T>> vertices) {
        this.vertices = vertices;
    }

    public void setDirigido(boolean dirigido) {
        this.dirigido = dirigido;
    }
    
    @Override
    public void agregarVertice(T elem) {
        if (buscarVertice(elem) != null) {
            return;
        }
        
        Vertice<T> v = new Vertice<>(elem);
        this.vertices.add(v);
    }

    @Override
    public void removerVertice(T elem) {
        Vertice<T> v = buscarVertice(elem);
        
        if (v == null) {
            return;
        }
        
        v.removerTodosArcos();
        
        for (Vertice iter: this.vertices) {
            this.removerArco((T) iter.getContenido(), elem);
        }
        
        this.vertices.remove(v);
    }

    @Override
    public void agregarArco(T elem1, T elem2) {
        
        Vertice<T> v1 = buscarVertice(elem1);
        Vertice<T> v2 = buscarVertice(elem2);
        
        if (v1 == null || v2 == null) {
            return;
        }
        
        v1.agregarArco(v2);
        if (!dirigido) {
            v2.agregarArco(v1);
        }
    }
    public void agregarArco(T elem1, T elem2,int peso) {
        
        Vertice<T> v1 = buscarVertice(elem1);
        Vertice<T> v2 = buscarVertice(elem2);
        
        if (v1 == null || v2 == null) {
            return;
        }
        
        v1.agregarArco(v2,peso);
        if (!dirigido) {
            v2.agregarArco(v1,peso);
        }
    }
    @Override
    public void removerArco(T elem1, T elem2) {
        Vertice<T> v1 = buscarVertice(elem1);
        Vertice<T> v2 = buscarVertice(elem2);
        
        if (v1 == null || v2 == null) {
            return;
        }
        
        v1.removerArco(v2);
        if (!dirigido) {
            v2.removerArco(v1);
        }
    }
    
    @Override
    public Vertice<T> buscarVertice(T elem) {
        for (Vertice<T> v : this.vertices) {
            if (v.getContenido().equals(elem)){
                return v;
            }
        }
        
        return null;
    }
    public Boolean buscarexiste(String element){
        if (vertices.contains(element)){
            return true;
        }
        return false;
    }
    
    @Override
    public void resetearVisitados() {
        for(Vertice<T> v: this.vertices) {
            v.setVisitado(false);
        }
    }


    
    public LinkedList<Vertice> getPadres(T elem1) {
        LinkedList<Vertice> padres= new LinkedList<> ();
        for (Vertice<T> v1: this.getVertices()) {
            Vertice<T> v2 =  new Vertice<>(elem1);
            Arco<T> arco = v1.buscarArco(v2);
            if(arco != null) {
                padres.add(v1);
                }
            }
        return padres;
    }

    public LinkedList<Vertice> getPadres(T elem1, int peso) {
        LinkedList<Vertice> padres= new LinkedList<> ();
        for (Vertice<T> v1: this.getVertices()) {
            Vertice<T> v2 =  new Vertice<>(elem1);
            Arco<T> arco = v1.buscarArco(v2);
            if(arco != null) {
                if(arco.getPeso()== peso)
                    padres.add(v1);
                }
            }
        return padres;
    }    

    @Override
    public String toString() {
        return "Grafo{" + "vertices=" + vertices + ", dirigido=" + dirigido + '}';
    }
    
    List<Vertice<T>> verticesrecorridos ;
     public void dijkstra(T inicio) {
         verticesrecorridos = new LinkedList<>();
        PriorityQueue<Vertice<T>> cola = new PriorityQueue<>(vertices.size(), (Vertice v1, Vertice v2) -> v1.getDistancia()- v2.getDistancia());
        for (Vertice vertice : vertices) {
            vertice.setDistancia(Integer.MAX_VALUE);
            vertice.setPrevio(null);
            vertice.setVisitado(false);
        }
        Vertice verticeOrigen = buscarVertice(inicio);
        verticeOrigen.setDistancia(0);
        cola.add(verticeOrigen);
        while (!cola.isEmpty()) {
            Vertice<T> menor = cola.poll();
            menor.setVisitado(true);
            for (Arco<T> arco : menor.getArcos()) {
                Vertice<T> destino = arco.getDestino();
                if (!destino.isVisitado() && destino.getDistancia() > menor.getDistancia() + arco.getPeso()) {
                    destino.setDistancia(menor.getDistancia() + arco.getPeso());
                    destino.setPrevio(menor);
                    cola.add(destino);
                    verticesrecorridos.add(destino);
                }
            }
        }

    }

    public double minimaDistancia(T origen, T destino) {
        dijkstra(origen);
        Vertice<T> vertice = buscarVertice(destino);
        return vertice.getDistancia();
    }

    public LinkedList<T> rutaMinima(T origen, T destino) {
        
        LinkedList<T> ruta = new LinkedList<>();
        dijkstra(origen);
        Vertice<T> vertice  = null;
        for(Vertice<T> v : verticesrecorridos){
            if(v.getContenido().equals(buscarVertice(destino).getContenido()))
                vertice = v;
        }
        Vertice<T> temporal = vertice;
        while (temporal != null) {
            ruta.addFirst(temporal.getContenido());
            temporal = temporal.getPrevio();
        }
        return ruta;
    }
}
