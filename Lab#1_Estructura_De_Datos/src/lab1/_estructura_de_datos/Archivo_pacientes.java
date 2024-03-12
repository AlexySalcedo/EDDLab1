         
package lab1._estructura_de_datos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
  
  public void Eliminar(long c){
      try{
      File fr = new File("C:\\Temp\\ArchivoPacientes.txt");
      FileWriter fw = new FileWriter(fr);
      BufferedWriter bw = new BufferedWriter(fw);
      List<String> l = new ArrayList<>();
      l = Files.readAllLines(Paths.get(fr.getPath()));
          for (String linea : l) {
              Pacientes pac = new Pacientes(linea);
              if (pac.getCedula() != c) {
               bw.write(linea + "\n");
              }
          }
      }
      catch(Exception ex){
          System.out.println(ex.getMessage());
      }
  }
  
  public void Eliminar(long c, String es){
      try{
      File fr = new File("C:\\Temp\\ArchivoPacientes.txt");
      FileWriter fw = new FileWriter(fr);
      BufferedWriter bw = new BufferedWriter(fw);
      List<String> l = new ArrayList<>();
      l = Files.readAllLines(Paths.get(fr.getPath()));
          for (String linea : l) {
              Pacientes pac = new Pacientes(linea);
              if (!(pac.getCedula() == c && pac.getEspecialidadMedica()==es)) {
               bw.write(linea + "\n");
              }
          }
      }
      catch(Exception ex){
          System.out.println(ex.getMessage());
      }
  }
  
  public static void main (String args[]) throws IOException {
      System.out.println("Estoy aqui");
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