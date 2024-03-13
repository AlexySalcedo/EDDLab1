package lab1._estructura_de_datos;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Archivo_pacientes {

    File archivoP = new File("C:\\Temp\\ArchivoPacientes.txt");
    
    
    //Creacion del archivo
    public void Crear_Archivo() {
        try {

            archivoP.createNewFile();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //Adicionar un paciente
    public void Adicionar(Pacientes pac) {
        try {
            FileWriter fw = new FileWriter("C:\\Temp\\ArchivoPacientes.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(pac.getDatos() + "\n");
            bw.flush();
            bw.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //Leer el archivo
    public ArrayList<Pacientes> Leer(){
        ArrayList<Pacientes> p = new ArrayList<Pacientes>();
        int i=0; 
        try {
            File f = new File("C:\\Temp\\ArchivoPacientes.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                Pacientes pac = new Pacientes(linea);
                    p.add(pac);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
           return p; 
    }
    
    //Consultar un paciente
    public ArrayList<Pacientes> Consultar(long c){
        ArrayList<Pacientes> p = new ArrayList<Pacientes>();
        int i=0; 
        try {
            File f = new File("C:\\Temp\\ArchivoPacientes.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                Pacientes pac = new Pacientes(linea);
                if (pac.getCedula()== c){
                    p.add(pac);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
           return p; 
    }

    //Eliminar todas las citas de un paciente
    public void Eliminar(long c) {
        ArrayList<Pacientes> p = new ArrayList<Pacientes>();
        p=Leer();        
        try {
            FileWriter fw = new FileWriter("C:\\Temp\\ArchivoPacientes.txt",false);
            BufferedWriter bw = new BufferedWriter(fw);
               for (int i =0;i<p.size(); i++){
                if (p.get(i).getCedula() != c) {
                    bw.write(p.get(i).getDatos() + "\n");
                }
            }
            bw.flush();
            bw.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //Eliminar una cita especifica del paciente
    public void Eliminar(long c, String es) {
        try {
            File fr = new File("C:\\Temp\\ArchivoPacientes.txt");
            FileWriter fw = new FileWriter(fr);
            BufferedWriter bw = new BufferedWriter(fw);
            List<String> l = new ArrayList<>();
            l = Files.readAllLines(Paths.get(fr.getPath()));
            for (String linea : l) {
                Pacientes pac = new Pacientes(linea);
                if (!(pac.getCedula() == c && pac.getEspecialidadMedica() == es)) {
                    bw.write(linea + "\n");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void Editar(long c) {
        try {
            File fr = new File("C:\\Temp\\ArchivoPacientes.txt");
            FileWriter fw = new FileWriter(fr);
            BufferedWriter bw = new BufferedWriter(fw);
            List<String> l = new ArrayList<>();
            l = Files.readAllLines(Paths.get(fr.getPath()));
            for (int i = 0; i < l.size(); i++) {
                String get = l.get(i);
                Pacientes pac = new Pacientes(get);
                if (pac.getCedula() == c) {
                    
                } else {
                    bw.write(pac.getDatos() + "\n");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String args[]) throws IOException {
        Pacientes p1 = new Pacientes();
        p1.setCedula(123456789);
        p1.setNombre("DDD");
        p1.setApellido("gGGGG");
        p1.setEspecialidadMedica("ddteo");
        p1.setMedicoAsignado("Candddddddi");
        p1.setFecha("5/10/2019");
        Archivo_pacientes ar = new Archivo_pacientes();
    
        ar.Crear_Archivo();
        ar.Adicionar(p1);
        ArrayList<Pacientes> p = new ArrayList<Pacientes>();
        ar.Eliminar(123);
        p=ar.Leer();
        int tam=p.size();
         System.out.println(tam);            
        for (int i =0;i<tam; i++){
         System.out.println(p.get(i).getDatos());
        }
  
        
    }
}
