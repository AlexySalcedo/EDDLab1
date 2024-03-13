/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package estructuradedatoslab.pkg1.pacientes_funciones;

import estructuradedatoslab.pkg1.Main;
import estructuradedatoslab.pkg1.VistaPrincipalController;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alexysalcedo
 */
public class PacientespageController implements Initializable {

    @FXML
    private BorderPane pn;
    @FXML
    private Pane pc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
        FXMLLoader ld= new FXMLLoader(getClass().getResource("/estructuradedatoslab/pkg1/VistaPrincipal.fxml"));
        Parent root = ld.load();
        VistaPrincipalController controlador = ld.getController();
        Scene scene = new Scene(root);
        Stage stage= new Stage();
   
        stage.setScene(scene);
        stage.show();
        Main.cerrar(event);
    }

    @FXML
    private void consulte(ActionEvent event) {
        loadpage("/estructuradedatoslab/pkg1/pacientes_funciones/btnConsultar.fxml");
    }
     private void loadpage(String page){
       Parent root= null;
        try {
            root=FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(VistaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
       pn.setCenter(root);
       
    }

    @FXML
    private void btnAgregarCita(ActionEvent event) {
        pn.setCenter(pc);
    }
}
