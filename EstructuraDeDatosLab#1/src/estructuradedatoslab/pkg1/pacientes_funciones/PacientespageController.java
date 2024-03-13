/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package estructuradedatoslab.pkg1.pacientes_funciones;

import estructuradedatoslab.pkg1.Backend.Archivo_pacientes;
import estructuradedatoslab.pkg1.Backend.Pacientes;
import estructuradedatoslab.pkg1.Main;
import estructuradedatoslab.pkg1.VistaPrincipalController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    @FXML
    private TextField setNombre;
    @FXML
    private TextField setIdentificacion;
    @FXML
    private TextField setespecialidad;
    @FXML
    private DatePicker setFecha;
    @FXML
    private TableView<Pacientes> tblPacientesAgr;
    @FXML
    private TableColumn<?, ?> colIdentificacion;
    @FXML
    private TableColumn<?, ?> colNombre;
    @FXML
    private TableColumn<?, ?> colEspecialidad;
    @FXML
    private TableColumn<?, ?> colFechaCita;
    @FXML
    private TableColumn<?, ?> colMedicoAsignado;
    
    private ObservableList <Pacientes> paciente;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Archivo_pacientes pepa = new Archivo_pacientes();
        paciente = FXCollections.observableList(pepa.Leer());
        this.colIdentificacion.setCellFactory(new PropertyValueFactory("cedula"));
        this.colNombre.setCellFactory(new PropertyValueFactory("nombre"));
        this.colFechaCita.setCellFactory(new PropertyValueFactory("fecha"));
        this.colMedicoAsignado.setCellFactory(new PropertyValueFactory("nombre"));
        this.colEspecialidad.setCellFactory(new PropertyValueFactory("especialidadMedica"));
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

    @FXML
    private void btnAñadirCita(ActionEvent event) {
        try {
        String name = setNombre.getText();
        long ide = Long.parseLong(setIdentificacion.getText());
        String espe = setespecialidad.getText();
        String fec= "03042024";
        
        
        Pacientes pa = new Pacientes(ide,name,"perez",espe,11,fec);
        this.paciente.add(pa);
        this.tblPacientesAgr.setItems (paciente) ;
        
        
        
        
        } catch(NumberFormatException e) {
            
        }
        
        
        
        
        
        
        
        
    }
}
