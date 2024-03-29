package lab1._estructura_de_datos;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Archivo_pacientes {

    File archivoP = new File("ArchivoPacientes.txt");
    
    
    //Creacion del archivo
    public void Crear_Archivo() {
        try {

            archivoP.createNewFile();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //Adicionar un paciente
    public boolean Adicionar(Pacientes pac) {
        ArrayList<Pacientes> p = new ArrayList<Pacientes>();
        p=Consultar(pac.getCedula());
        boolean sw=true;
        for (int i = 0; i < p.size(); i++) {
            if ((p.get(i).getCedula() == pac.getCedula()) && (p.get(i).getEspecialidadMedica().equals(pac.getEspecialidadMedica())) && (p.get(i).getames() == pac.getames())) {
                    sw = false;
            }
        }
        if (sw == true){
        try {
            FileWriter fw = new FileWriter("ArchivoPacientes.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(pac.getDatos() + "\n");
            bw.flush();
            bw.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
         }
       }
        return sw;
    }
    
    //Leer el archivo
    public ArrayList<Pacientes> Leer(){
        ArrayList<Pacientes> p = new ArrayList<Pacientes>();
        int i=0; 
        try {
            File f = new File("ArchivoPacientes.txt");
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
        try {
            File f = new File("ArchivoPacientes.txt");
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

    //Elimar todas las citas de un paciente
    public void Eliminar(long c) {
        ArrayList<Pacientes> p = new ArrayList<Pacientes>();
        p=Leer();        
        try {
            FileWriter fw = new FileWriter("ArchivoPacientes.txt",false);
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
        ArrayList<Pacientes> p = new ArrayList<Pacientes>();
        p=Leer();        
        try {
            FileWriter fw = new FileWriter("ArchivoPacientes.txt",false);
            BufferedWriter bw = new BufferedWriter(fw);
               for (int i =0;i<p.size(); i++){
                if ((p.get(i).getCedula() != c) && !(p.get(i).getEspecialidadMedica().equals(es))) {
                    bw.write(p.get(i).getDatos() + "\n");
                }
            }
            bw.flush();
            bw.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //Eliminar citas asignadas
    public void EliminarC(long id) {
        ArrayList<Pacientes> p = new ArrayList<Pacientes>();
        p=Leer();        
        try {
            FileWriter fw = new FileWriter("ArchivoPacientes.txt",false);
            BufferedWriter bw = new BufferedWriter(fw);
               for (int i =0;i<p.size(); i++){
                if ((p.get(i).getMedicoAsignado() != id))  {
                    bw.write(p.get(i).getDatos() + "\n");
                }
            }
            bw.flush();
            bw.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    
}
