




import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.espol.edu.ec.grafos.lista.Aeropuerto; 
import org.espol.edu.ec.grafos.lista.Grafo;
import org.espol.edu.ec.grafos.lista.Ruta;
/**
 *
 * @author Israel
 * 
 */
public class JavaFXComboBox extends Application  {
     @Override
    public void start(Stage primaryStage) {
        
        final ComboBox comboBox = new ComboBox();
        Main1 metodos=new Main1();
        LinkedList<Aeropuerto> aerop = metodos.leerAeropuertos(8107);
        LinkedList<String> paisesVisitados=new LinkedList<>();
        for(Aeropuerto a:aerop){
            String Pais=a.getCountry();

            
            if(!paisesVisitados.contains(Pais)){
                //System.out.println("Agregado");
                System.out.println(Pais);
                paisesVisitados.add(Pais);
                comboBox.getItems().add(Pais);
        
                
            }
            
            
        
        }
        comboBox.setValue("Elegir Pais");
        
        final Label label = new Label();
        
        Button btn = new Button();
        final ComboBox comboBox1 = new ComboBox();
        final ComboBox comboBox2 = new ComboBox();
        final Label labe2 = new Label();
        final Label labe3 = new Label();
        Button btn1 = new Button();
        labe2.setText("Aeropuerto de salida");
        labe3.setText("Aeropuerto de llegada");
        btn.setText("Escoger");
        btn1.setText("Buscar ruta optima");
        btn.setOnAction((ActionEvent event) -> {
            label.setText("Pais seleccionado: " + comboBox.getValue());
            String eleccion = comboBox.getValue().toString();
            System.out.println("Pais escogido: "+ eleccion);
            LinkedList<Aeropuerto> list = Main1.leerAeropuertosPais(eleccion); 
            LinkedList<String> nueva = listaString(list);
            comboBox1.getItems().addAll(nueva);
            comboBox2.getItems().addAll(nueva);
            btn1.setOnAction((ActionEvent event1) -> {
                
                try {
                    Grafo<Aeropuerto> grafo2 = new Grafo<>(true);
                    HashMap<String, Aeropuerto> map1 = metodos.transformarMap(list);
                    metodos.agregarListaVertices(list, grafo2);
                    LinkedList<Ruta> rut1 = metodos.leerRutas();
                    Main2.agregarRutas(rut1, grafo2, map1);
                    
                    String pais1 = comboBox1.getValue().toString();
                    String pais2 = comboBox2.getValue().toString();
                    Aeropuerto inicio = metodos.obtenerAeropuertoNombre(pais1, aerop);
                    Aeropuerto destino = metodos.obtenerAeropuertoNombre(pais2, aerop);
                    System.out.println("Aeropuerto de partida: "+inicio);
                    System.out.println("Aeropuerto de llegada: "+destino);
                    System.out.println(grafo2);
                    System.out.println(grafo2.rutaMinima(inicio, destino));
//                    for (Aeropuerto aereo : grafo2.rutaMinima(inicio, destino)) {
//                        System.out.println(aereo.getName());}
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JavaFXComboBox.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NullPointerException e){
                    System.out.println("Hola mundo no corre esta vaina");
                }
            });
        });
        
        
        
        

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.setSpacing(5);
        vBox.getChildren().addAll(label, comboBox, btn,labe2, comboBox1,labe3, comboBox2,btn1);
        
        StackPane root = new StackPane();
        root.getChildren().add(vBox);
        
        Scene scene = new Scene(root, 300, 350);
        
        primaryStage.setTitle("Aeropuertos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static LinkedList<String> listaString(LinkedList<Aeropuerto> list){
        LinkedList<String> result = new LinkedList<>();
        for(Aeropuerto temp: list){
            String x = temp.getName();
            result.add(x);
        }
        return result;
    }
}
