
package estructuradedatoslab.pkg1.pacientes_funciones;

import estructuradedatoslab.pkg1.Backend.Archivo_pacientes;
import estructuradedatoslab.pkg1.Backend.Pacientes;
import estructuradedatoslab.pkg1.Main;
import estructuradedatoslab.pkg1.VistaPrincipalController;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javax.swing.JOptionPane;

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
    private ChoiceBox<String> setespecialidad;
    @FXML
    private DatePicker setFecha;
    @FXML
    private TableView<Pacientes> tblPacientesAgr;
    @FXML
    private TableColumn colIdentificacion;
    @FXML
    private TableColumn  colNombre;
    @FXML
    private TableColumn colEspecialidad;
    @FXML
    private TableColumn colFechaCita;
    @FXML
    private TableColumn colMedicoAsignado;
    
    private ObservableList <Pacientes> paciente;
    @FXML
    private TableColumn colApellido;
    @FXML
    private ChoiceBox<?> SelcMedicos;
    @FXML
    private TextField setApellido;
    
Archivo_pacientes pacien = new Archivo_pacientes();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        paciente = FXCollections.observableList(pacien.Leer());
        this.colIdentificacion.setCellValueFactory(new PropertyValueFactory("cedula"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colFechaCita.setCellValueFactory(new PropertyValueFactory("fecha"));
        this.colMedicoAsignado.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colEspecialidad.setCellValueFactory(new PropertyValueFactory("especialidadMedica"));
        this.colApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        this.setespecialidad.setItems(FXCollections.observableArrayList("Neurologia","Medicina General", "Pediatria", "Cardiologia"));
        this.tblPacientesAgr.setItems(paciente);
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
        this.tblPacientesAgr.setItems(paciente);
    }

    @FXML
    private void btnAñadirCita(ActionEvent event) {
        try {
        boolean sw = true;    
        String name = setNombre.getText();
        long ide = Long.parseLong(setIdentificacion.getText());
        String espe = setespecialidad.getValue();
        LocalDate fechita = setFecha.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        
        String fecc= fechita.format(formatter);
        String apel= setApellido.getText();
       

        Pacientes pa = new Pacientes(ide,name,apel,espe,"juan",fecc);
    

        sw = this.pacien.Adicionar(pa); 
        if (sw == true){       
            this.paciente.add(pa);
            this.tblPacientesAgr.setItems(paciente);
        }
        
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el contacto\nVerifique los datos ingresados", "ERROR", 0);
        }
        
        
        
        
        
        
        
        
    }
}
