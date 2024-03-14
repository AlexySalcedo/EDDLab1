/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package estructuradedatoslab.pkg1.pacientes_funciones;

import estructuradedatoslab.pkg1.Backend.Archivo_pacientes;
import estructuradedatoslab.pkg1.Backend.Pacientes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author alexysalcedo
 */
public class BtnConsultarController implements Initializable {

    @FXML
    private TextField setId;
    @FXML
    private TableView<Pacientes> tblConsultar;
    @FXML
    private TableColumn colIdentificacion;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellido;
    @FXML
    private TableColumn colEspecialidad;
    @FXML
    private TableColumn colMedicoAsignado;
    
    private ObservableList <Pacientes> paciente; 

    /**
     * Initializes the controller class.
     * 
     */
    
    Archivo_pacientes pacien = new Archivo_pacientes();
    @FXML
    private TableColumn<?, ?> colFechaCita;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        paciente = FXCollections.observableList(pacien.Leer());
        this.colIdentificacion.setCellValueFactory(new PropertyValueFactory("cedula"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colFechaCita.setCellValueFactory(new PropertyValueFactory("fecha"));
        this.colMedicoAsignado.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colEspecialidad.setCellValueFactory(new PropertyValueFactory("especialidadMedica"));
        this.colApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        
    }    

    @FXML
    private void buscar(ActionEvent event) {
         long id= Long.parseLong(setId.getText());
         paciente = FXCollections.observableList(pacien.Consultar(id));
         this.tblConsultar.setItems(paciente);
         
    }

    @FXML
    private void eliminar(ActionEvent event) {
    }

    @FXML
    private void eliminartodo(ActionEvent event) {
        long id= Long.parseLong(setId.getText());
        pacien.Eliminar(id);
        paciente = FXCollections.observableList(pacien.Consultar(id));
        this.tblConsultar.setItems(paciente);
    }
    
}
