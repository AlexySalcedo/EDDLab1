/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package estructuradedatoslab.pkg1.paginasDelView;

import estructuradedatoslab.pkg1.Main;
import estructuradedatoslab.pkg1.medicos_funciones.MedicosPageController;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alexysalcedo
 */
public class PersonasYmedicosController implements Initializable {
   

    @FXML
    private AnchorPane fondo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void abrirPacientes(ActionEvent event) throws IOException {
       FXMLLoader ld= new FXMLLoader(getClass().getResource("/estructuradedatoslab/pkg1/pacientes_funciones/Pacientespage.fxml"));
        Parent root = ld.load();
        PacientespageController controlador = ld.getController();
        Scene scene = new Scene(root);
        Stage stage= new Stage();
   
        stage.setScene(scene);
        stage.show();
        Main.cerrar(event);
        
    }

    @FXML
    private void abrirMedicos(ActionEvent event) throws IOException {
        FXMLLoader ld= new FXMLLoader(getClass().getResource("/estructuradedatoslab/pkg1/medicos_funciones/MedicosPage.fxml"));
        Parent root = ld.load();
       MedicosPageController controlador = ld.getController();
        Scene scene = new Scene(root);
        Stage stage= new Stage();
   
        stage.setScene(scene);
        stage.show();
        Main.cerrar(event);
        
        
    }
    

    
}
