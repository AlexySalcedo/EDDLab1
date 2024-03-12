
package lab1._estructura_de_datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo_pacientes {
  File archivoP;
    
  private void CrearArchivoPacientes(){
      this.archivoP = new File ("ArchivoPacientes.txt");
  }
  
  public void Adicionar(Pacientes pac) throws IOException{
      FileWriter fw= new FileWriter("ArchivoPacientes.txt",true);
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(pac.getDatos()+"\n");
      bw.flush();
      bw.close();
  }
  
 
  
}
        
            
