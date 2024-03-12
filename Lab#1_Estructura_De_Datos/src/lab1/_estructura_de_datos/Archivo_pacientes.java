         
package lab1._estructura_de_datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo_pacientes {
    
    
    File archivoP = new File ("C:\\Temp\\ArchivoPacientes.txt");
    
  public void Crear_Archivo(){
      try {
      
      archivoP.createNewFile();
      } 
      catch(Exception ex){
          System.out.println(ex.getMessage());
      }
  }
  
  public void Adicionar(Pacientes pac){
      try{
      FileWriter fw= new FileWriter("C:\\Temp\\ArchivoPacientes.txt",true);
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(pac.getDatos()+"\n");
      bw.flush();
      bw.close();}
      catch(Exception ex){
          System.out.println(ex.getMessage());
      }
  }
  
  public static void main (String args[]) throws IOException {
      Pacientes p1 = new Pacientes();
       p1.setCedula(100242);
        p1.setNombre("diana");
        p1.setApellido("garcia");
        p1.setEspecialidadMedica("fao");
        p1.setMedicoAsignado("andi");
      Archivo_pacientes ar = new Archivo_pacientes();
      //archivoP = new File ("C:\\Temp\\ArchivoPacientes.txt");
      ar.Crear_Archivo();
      ar.Adicionar(p1);
  }
  }