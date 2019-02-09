import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import org.espol.edu.ec.grafos.lista.Aeropuerto;
//import org.espol.edu.ec.grafos.algoritmos.GrafosAlgoritmos;
import org.espol.edu.ec.ui.GrafoUI;
import org.espol.edu.ec.grafos.lista.Grafo;
import org.espol.edu.ec.grafos.lista.Ruta;
import org.espol.edu.ec.grafos.lista.Vertice;


/**
 *
 * @author ancalder
 */
public class Main1 {
    
    public static void main(String[] args) throws FileNotFoundException {
        //Primera Parte
        System.out.println("Primera Parte");
        System.out.println("-------------");
        System.out.println();
        Grafo<Aeropuerto> grafo2 = new Grafo<>(true);
        LinkedList<Aeropuerto> aerop = leerAeropuertos(50);   
        HashMap<String, Aeropuerto> map = transformarMap(aerop);
        agregarListaVertices(aerop, grafo2);
        LinkedList<Ruta> rut = leerRutas();
        agregarRutas(rut, grafo2, map);
        //System.out.println(grafo2);
        GrafoUI<Aeropuerto> grafoUI = new GrafoUI(grafo2);
        grafoUI.mostrarGrafo();
        System.out.println();
        
    }
    
    
    public static void agregarListaVertices(LinkedList<Aeropuerto> list, Grafo<Aeropuerto> grafo){
        for(Aeropuerto temp: list){
        if (grafo.buscarVertice(temp) != null) {
            return;
        }
        
        Vertice<Aeropuerto> v = new Vertice<>(temp);
        grafo.getVertices().add(v);}
    }
        
    
    public static HashMap<String, Aeropuerto> transformarMap(LinkedList<Aeropuerto> list){
        HashMap<String, Aeropuerto> result = new HashMap<>();
        for(Aeropuerto aer : list){
            result.put(aer.getIATA_FAA(), aer);
        }
        return result;
    }
    
    public static void agregarRutas(LinkedList<Ruta> rutas, Grafo<Aeropuerto> grafo, HashMap<String, Aeropuerto> map){
        for(Vertice<Aeropuerto> verticeInicial : grafo.getVertices()){
            String codigo = verticeInicial.getContenido().getIATA_FAA();
            for(Ruta ruta : rutas){    
                if(codigo.equals("\""+ruta.getSource_airport()+"\"") && map.get("\""+ruta.getDestination_airport()+"\"")!=null ){
                    Aeropuerto v = map.get("\""+ruta.getDestination_airport()+"\"");
                    Vertice<Aeropuerto> vert = new Vertice<>(v);
                    verticeInicial.agregarArco(vert);
 
                }
            }
        }
    }
    
    public static LinkedList<Aeropuerto> leerAeropuertos(int maximo){
        LinkedList<Aeropuerto> listaAeropuerto = new LinkedList();
        try{
            File archivo = new File("airports.dat");
            Scanner input = new Scanner(archivo);
            input.useDelimiter("\n");
            int contador = 0;
            while(input.hasNext() && contador<maximo){
                String linea = input.next();
                String[] cadenas = linea.split(",");
                listaAeropuerto.add(new Aeropuerto(cadenas[0], cadenas[1], cadenas[2], cadenas[3], cadenas[4], cadenas[5], Double.parseDouble(cadenas[6]), Double.parseDouble(cadenas[7]), Integer.parseInt(cadenas[8]), Double.parseDouble(cadenas[9]), cadenas[10] ));
                contador ++;
            }
            return listaAeropuerto;
        }catch(FileNotFoundException e){
            return listaAeropuerto; 
        }
    }
    
    public static LinkedList<Aeropuerto> leerAeropuertosPais(String pais){
        LinkedList<Aeropuerto> listaAeropuerto = new LinkedList();
        try{
            File archivo = new File("airports.dat");
            Scanner input = new Scanner(archivo);
            input.useDelimiter("\n");
            while(input.hasNext()){
                String linea = input.next();
                String[] cadenas = linea.split(",");
                if(cadenas[3].equals(pais)){
                listaAeropuerto.add(new Aeropuerto(cadenas[0], cadenas[1], cadenas[2], cadenas[3], cadenas[4], cadenas[5], Double.parseDouble(cadenas[6]), Double.parseDouble(cadenas[7]), Integer.parseInt(cadenas[8]), Double.parseDouble(cadenas[9]), cadenas[10] ));
                }
            }
            return listaAeropuerto;
        }catch(FileNotFoundException e){
            return listaAeropuerto; 
        }
    }
    
    public static LinkedList<Ruta> leerRutas() throws FileNotFoundException{
        LinkedList<Ruta> listaRutas = new LinkedList<>();
        try{
            File archivo = new File("routes.dat");
            Scanner input = new Scanner(archivo);
            input.useDelimiter("\n");
            while(input.hasNext()){
                String linea = input.next();
                String[] cadenas = linea.split(",");
                if(!"\\N".equals(cadenas[1]) && !"\\N".equals(cadenas[3]) && !"\\N".equals(cadenas[5]) ){
                listaRutas.add(new Ruta(cadenas[0], Integer.parseInt(cadenas[1]), cadenas[2], Integer.parseInt(cadenas[3]), cadenas[4], Integer.parseInt(cadenas[5]), cadenas[6], Integer.parseInt(cadenas[7]), cadenas[8]));
                }else{
                  for(int j=1; j<6;j++){
                      if("\\N".equals(cadenas[j])){
                          cadenas[j]="0";
                      }
                  }
                listaRutas.add(new Ruta(cadenas[0], Integer.parseInt(cadenas[1]), cadenas[2], Integer.parseInt(cadenas[3]), cadenas[4], Integer.parseInt(cadenas[5]), cadenas[6], Integer.parseInt(cadenas[7]), cadenas[8]));  
                }}
            return listaRutas;
        }catch(FileNotFoundException e){
            return listaRutas; 
        }
    }
    
    public static Aeropuerto obtenerAeropuertoNombre(String nombre,LinkedList<Aeropuerto> lista ){
        for(Aeropuerto temp: lista){
            if(nombre.equals(temp.getName())){
                return temp;
            }
        }
        return null;
    }
    
}

