
package estructuradedatoslab.pkg1;

import estructuradedatoslab.pkg1.pacientes_funciones.PacientespageController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class VistaPrincipalController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private Pane cp;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void home(ActionEvent event) {
        bp.setCenter(cp);
        
    }
   

    @FXML
    private void people(ActionEvent event) {
        
        loadpage("/estructuradedatoslab/pkg1/paginasDelView/PersonasYmedicos.fxml");
    
    }

    @FXML
    private void calendar(ActionEvent event) {
        loadpage("/estructuradedatoslab/pkg1/paginasDelView/Calendario.fxml");
    }

    @FXML
    private void settings(ActionEvent event) {
        loadpage("/estructuradedatoslab/pkg1/paginasDelView/Configuracion.fxml");
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
            FXMLLoader ld= new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = ld.load();
        InterfazController controlador = ld.getController();
        Scene scene = new Scene(root);
        Stage stage= new Stage();
   
        stage.setScene(scene);
        stage.show();
        Main.cerrar(event);
        
    }
    @FXML
    private void help(ActionEvent event){
        
    }
     private void loadpage(String page){
       Parent root= null;
        try {
            root=FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(VistaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
       bp.setCenter(root);
       
    }
  
}
