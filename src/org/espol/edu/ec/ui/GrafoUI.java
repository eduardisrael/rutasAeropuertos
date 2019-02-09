package org.espol.edu.ec.ui;

import java.util.LinkedList;
import java.util.ListIterator;
import org.espol.edu.ec.grafos.lista.*;

// Estas librerias se encuentran en:
//     -->./lib/gs-core-1.3
//     -->./lib/gs-ui-1.3
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author markoscalderon
 */
public class GrafoUI<T> {
    private Graph graph;
    
    public GrafoUI(Grafo<Aeropuerto> g){
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        graph = new SingleGraph("Grafo");
        //-->aqui se enuentra el archivo de configuracion:  ./lib/styles.css
        //Para mas detalles ver:  http://graphstream-project.org/doc/Advanced-Concepts/GraphStream-CSS-Reference/
        graph.addAttribute("ui.stylesheet", "url(./lib/styles.css)");
        graph.addAttribute("ui.quality");
        graph.addAttribute("ui.antialias");
        
        //dibujar los vertices
        for (Vertice<Aeropuerto> v: g.getVertices()) {
            String finale = v.getContenido().getName();
            graph.addNode(finale).addAttribute("ui.label", finale);
        }
        
        //buscar arcos dddel grafo
        for (Vertice<Aeropuerto> v1: g.getVertices()) {
            for (Vertice<Aeropuerto> v2: g.getVertices()) {
                Arco<Aeropuerto> arco = v1.buscarArco(v2);
                if(arco != null) {
                    String cv1 = v1.getContenido().getName();
                    String cv2 = v2.getContenido().getName();
                    if (!g.isDirigido()) {
                        if (graph.getNode(cv1).hasEdgeBetween(cv2)) {
                            continue;
                        }
                    }
                    //dibujar los arcos
                    Edge edge = graph.addEdge(cv1+cv2, cv1, cv2, g.isDirigido());
                    if (arco.getPeso() != -1) {//si el arco tiene un peso asignado (No es -1) se cambia el formato
                        if(arco.getPeso() ==1) {
                            //Si peso del arco es menor a 10 dibujarlo en amarillo
                            edge.addAttribute("ui.label", arco.getPeso()); //mostrar etiqueta
                            edge.addAttribute("ui.style", "fill-color: rgb(255,255,0);");//pintar arco amarillo
                        }
                        else {//Si peso del arco es mayor o igual a 10 dibujarlo  en azul
                            edge.addAttribute("ui.label", arco.getPeso());//mostrar etiqueta
                            edge.addAttribute("ui.style", "fill-color: rgb(0,0,255);");//pintar arco azul
                        }
                    }
                }
            }
        }
    }

    public void mostrarGrafo() {
        graph.display();
        try { Thread.sleep(1500); } catch (Exception e) {}
    }
    
    public void mostrarRecorrido(LinkedList<T> vertices){
        ListIterator<T> k = vertices.listIterator();

        while (k.hasNext()) {
            T v = k.next();
            Node nodo = graph.getNode(v.toString());
            nodo.setAttribute("ui.class", "marked");
            try { Thread.sleep(1500); } catch (Exception e) {}
        }
    }
}