/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package estructuradedatoslab.pkg1.medicos_funciones;

import estructuradedatoslab.pkg1.Backend.ArchivoMedicos;
import estructuradedatoslab.pkg1.Backend.Medicos;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
public class MedicosPageController implements Initializable {

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
    @FXML
    private TextField setNombre;
    @FXML
    private TextField setTelefono;
    @FXML
    private TextField setIdentificacion;
    @FXML
    private TextField setEspecialidad;
    @FXML
    private Button abrirConsulta;
    
    private ObservableList <Medicos> medico;
    
    ArchivoMedicos medi= new ArchivoMedicos();
    @FXML
    private BorderPane pt;
    @FXML
    private Pane cp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         medico = FXCollections.observableList(medi.Leer());
        this.identificacion.setCellValueFactory(new PropertyValueFactory("identificacion"));
        this.nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.telefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        this.numerodecitas.setCellValueFactory(new PropertyValueFactory("cita"));
        this.especialidad.setCellValueFactory(new PropertyValueFactory("especialidad"));
        
        
        this.tblMedicosAg.setItems(medico);
        
    }    

    @FXML
    private void btnIngresar(ActionEvent event) {
        try{
        boolean sw = true;
        String nombre = setNombre.getText();
        String especialidad = setEspecialidad.getText();
        long telefono = Long.parseLong(setTelefono.getText());
        long id= Long.parseLong(setIdentificacion.getText());
        
        Medicos m= new Medicos( id, nombre,  especialidad, telefono);
        if ((id >10000000) && (telefono > (1000000000))){
         this.medico.add(m);
         if (sw == true){
         this.tblMedicosAg.setItems(medico);
         this.medi.Adicionar(m);
         }
        }else{
            JOptionPane.showMessageDialog(null, "Error en dato", "ERROR", 0);
        }
        setNombre.setText(null);
        setTelefono.setText(null);
        setIdentificacion.setText(null);
        setEspecialidad.setText(null);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo agregar el contacto\nVerifique los datos ingresados", "ERROR", 0);
        }        
    }

    @FXML
    private void salir(ActionEvent event) throws IOException {
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
    private void btnañadirmedicos(ActionEvent event) {
        pt.setCenter(cp);
    }

    @FXML
    private void btnconsultamed(ActionEvent event) {
        loadpage("/estructuradedatoslab/pkg1/medicos_funciones/btnConsultarmed.fxml");
    }
     private void loadpage(String page){
       Parent root= null;
        try {
            root=FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(VistaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
       pt.setCenter(root);
       
    }
    
}
