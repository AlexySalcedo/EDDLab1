/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package estructuradedatoslab.pkg1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alexysalcedo
 */
public class InterfazController implements Initializable {

    @FXML
    private Button btnIngresar;
    @FXML
    private TextField user;
    @FXML
    private PasswordField password;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // 
    }    

    @FXML
    private void clickIngresar(ActionEvent event) throws IOException {
        String usuario="Diana_Carolina";
        String usuario1="Mei_Ching";
        String usuario2="Alexy_Salcedo";
        String contraseña= "123";
        String val=user.getText();
        String contra=password.getText();
        if((val.equals(usuario)||val.equals(usuario1)||val.equals(usuario2))&&(contra.equals(contraseña))){
        FXMLLoader ld= new FXMLLoader(getClass().getResource("VistaPrincipal.fxml"));
        Parent root = ld.load();
        VistaPrincipalController controlador = ld.getController();
        Scene scene = new Scene(root);
        Stage stage= new Stage();
   
        stage.setScene(scene);
        stage.show();
        Main.cerrar(event);
        }else{
            user.setText("Contraseña o usuario incorrecto");
        }
        
    }
    
}
