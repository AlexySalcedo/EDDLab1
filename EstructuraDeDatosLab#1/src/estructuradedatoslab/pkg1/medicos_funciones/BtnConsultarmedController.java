/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package estructuradedatoslab.pkg1.medicos_funciones;

import estructuradedatoslab.pkg1.Backend.ArchivoMedicos;
import estructuradedatoslab.pkg1.Backend.Medicos;
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
public class BtnConsultarmedController implements Initializable {

    @FXML
    private TextField consulta;
    @FXML
    private TableView<Medicos> tblMedicosAg;
    @FXML
    private TableColumn identificacion;
    @FXML
    private TableColumn nombre;
    @FXML
    private TableColumn telefono;
    @FXML
    private TableColumn especialidad;
    @FXML
    private TableColumn numerodecitas;
    
    private ObservableList <Medicos> medicop;
    @FXML
    private TextField nombremedico;

    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
       medicop = FXCollections.observableList(medi.Leer());
        this.identificacion.setCellValueFactory(new PropertyValueFactory("identificacion"));
        this.nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.telefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        this.numerodecitas.setCellValueFactory(new PropertyValueFactory("cita"));
        this.especialidad.setCellValueFactory(new PropertyValueFactory("especialidad"));
    }    

    @FXML
    private void consultar(ActionEvent event) {
        long id=Long.parseLong(consulta.getText());
        medicop = FXCollections.observableList(medi.Consultar(id));
        this.tblMedicosAg.setItems(medicop);
        
    }
    ArchivoMedicos medi= new ArchivoMedicos();

    @FXML
    private void eliminarmedico(ActionEvent event) {
        try{
        String name = nombremedico.getText();
        medi.Eliminar1(name);
        this.tblMedicosAg.setItems(medicop);
        }catch(Exception e){
        }
        
    }

    @FXML
    private void reiniciarcitas(ActionEvent event) {
        medi.reiniciar();
        
        this.tblMedicosAg.setItems(medicop);
    }

    
}
