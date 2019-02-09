package org.espol.edu.ec.grafos.lista;

import java.util.LinkedList;

/**
 *
 * @author ancalder
 */
public class Vertice<T> {
    private boolean visitado;
    private T contenido;
    private LinkedList<Arco> arcos;
    
    private Vertice<T> previo;
    private int distancia;

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }


    public Vertice(T contenido) {
        this.contenido = contenido;
        this.arcos = new LinkedList<>();
        this.visitado = false;
    }

    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }
    
        public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public LinkedList<Arco> getArcos() {
        return arcos;
    }

    public void setArcos(LinkedList<Arco> arcos) {
        this.arcos = arcos;
    }
    
    public void agregarArco(Vertice<T> destino) {
        if (buscarArco(destino) != null) {
            return;
        }
        
        this.arcos.add(new Arco(destino));
    }
    
    public void agregarArco(Vertice<T> destino,int peso) {
        if (buscarArco(destino) != null) {
            return;
        }
        
        this.arcos.add(new Arco(destino,peso));
    }
    
    public void removerArco(Vertice<T> destino) {
        Arco<T> arco = buscarArco(destino);
        
        if (arco == null) {
            return;
        }
        
        this.arcos.remove(arco);
    }
    
    public Arco<T> buscarArco(Vertice<T> destino) {
        for (Arco<T> a: this.arcos) {
            if (a.getDestino().equals(destino)) {
                return a;
            }
        }
        return null;
    }

    public void removerTodosArcos() {
        this.arcos.clear();
    }

    @Override
    public String toString() {
        return "Vertice{" + "visitado=" + visitado + ", contenido=" + contenido + ", arcos=" + arcos + '}';
    }


    
    public boolean equals(Vertice<T> v) {
        return this.contenido.equals(v.contenido);
    }
    
    
    
    
    
    public Vertice<T> getPrevio() {
        return previo;
    }

 

    public void setPrevio(Vertice<T> previo) {
        this.previo = previo;
    }

}
