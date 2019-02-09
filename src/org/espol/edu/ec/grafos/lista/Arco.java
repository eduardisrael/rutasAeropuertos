package org.espol.edu.ec.grafos.lista;

/**
 *
 * @author ancalder
 */
public class Arco<T> {
    private Vertice<T> destino;
    private int peso;

    public Arco(Vertice<T> destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public Arco(Vertice<T> destino) {
        this.destino = destino;
        this.peso = -1;
    }

    public Vertice<T> getDestino() {
        return destino;
    }

    public void setDestino(Vertice<T> destino) {
        this.destino = destino;
    }
    
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Arco{" + "destino=" + destino.getContenido() + ", peso=" + peso + '}';
    }
     
}
