
package estructuradedatoslab.pkg1;

import estructuradedatoslab.pkg1.Backend.ArchivoMedicos;
import estructuradedatoslab.pkg1.Backend.Archivo_pacientes;
import estructuradedatoslab.pkg1.pacientes_funciones.PacientespageController;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene (new Scene(root)) ;
        primaryStage.show();
        medic.crearArchivoM();
        pace.Crear_Archivo();
    
        
        
    }
 
static ArchivoMedicos medic = new ArchivoMedicos();
static Archivo_pacientes pace = new Archivo_pacientes();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    public static void cerrar(ActionEvent e){
        Node source = (Node)e.getSource();
        Stage stage =(Stage)source.getScene().getWindow();
        stage.close();
    }
    
}
