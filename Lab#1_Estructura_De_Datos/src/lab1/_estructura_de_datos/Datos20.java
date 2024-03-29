package lab1._estructura_de_datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Datos20 {
    
    File archivoM = new File("ArchivoMedicos.txt");
    
    //Creacion del archivo
    public void Crear_Archivo() {
        try {
            archivoM.createNewFile();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //Adicionar un medico
    public boolean Adicionar(Medicos med) {
        ArrayList<Medicos> m = new ArrayList<Medicos>();
        m=Consultar(med.getIdentificacion());
        boolean sw=true;
        for (int i = 0; i < m.size(); i++) {
            if ((m.get(i).getIdentificacion() == med.identificacion) && (m.get(i).getEspecialidad().equals(med.getEspecialidad()))) {
                    sw = false;
            }
        }
        if (sw == true){
        try {
            FileWriter fw = new FileWriter("ArchivoMedicos.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(med.getDatos() + "\n");
            bw.flush();
            bw.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
         }
       }
        return sw;
    }
    //Leer el archivo
    public ArrayList<Medicos> Leer(){
        ArrayList<Medicos> m = new ArrayList<Medicos>(); 
        try {
            File f = new File("ArchivoMedicos.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                Medicos med = new Medicos(linea);
                    m.add(med);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
           return m; 
    }
    
    //Consultar un medico
    public ArrayList<Medicos> Consultar(long c){
        ArrayList<Medicos> m= new ArrayList<Medicos>();
        try {
            File f = new File("ArchivoMedicos.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                Medicos med = new Medicos(linea);
                if (med.getIdentificacion()== c){
                    m.add(med);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
           return m; 
    }
    
    //Eliminar un medico
    public void Eliminar(long c) {
        ArrayList<Medicos> m = new ArrayList<Medicos>();
        m=Leer();        
        try {
            FileWriter fw = new FileWriter("ArchivoPacientes.txt",false);
            BufferedWriter bw = new BufferedWriter(fw);
               for (int i =0;i<m.size(); i++){
                if (m.get(i).getIdentificacion() != c) {
                    bw.write(m.get(i).getDatos() + "\n");
                }
            }
            bw.flush();
            bw.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    int bayter = 0, gomez = 0, medina = 0, perez = 0, botero = 0, molina = 0, aroca = 0, camargo = 0, tellez = 0, cochero = 0;

    public void AsignarCita() {
        Scanner sc = new Scanner(System.in);

        String especialidadSolicitada = "n"; //SOLICITADA EN PACIENTES

        if (especialidadSolicitada.equalsIgnoreCase("nutricionista")) {
            asignar(bayter, gomez, "nutricionista");
        }
        if (especialidadSolicitada.equalsIgnoreCase("cardiologos")) {
            asignar(medina, perez, "cardiologos");
        }
        if (especialidadSolicitada.equalsIgnoreCase("pediatras")) {
            asignar(botero, molina, "pediatras");
        }
        if (especialidadSolicitada.equalsIgnoreCase("dermatologos")) {
            asignar(aroca, camargo, "dermatologos");
        }
        if (especialidadSolicitada.equalsIgnoreCase("medico general")) {
            asignar(tellez, cochero, "medico general");
        }
    }

    public void asignar(int doctor1, int doctor2, String especialidad) {
        Scanner sc = new Scanner(System.in);

        if (doctor1 < 10 && doctor2 < 10) {
            System.out.println(especialidad + ": 1. " + doctor1 + " - 2. " + doctor2);
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    doctor1++;
                    break;
                case 2:
                    doctor2++;
                    break;
                default:
                    throw new AssertionError();
            }
        } else if (doctor1 < 10) {
            doctor1++;
        } else if (doctor2 < 10) {
            doctor2++;
        } else {
            System.out.println("NO HAY MEDICOS DISPONIBLES");
        }
    }

    public void eliminar(int doctor1, int doctor2, String especialidad) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("SELECCIONE MEDICO: 1. " + doctor1 + " - 2. " + doctor2);
        int med = sc.nextInt();
        switch (med) {
            case 1:
                doctor1--;
                break;
            case 2:
                doctor2--;
                break;
            default:
                throw new AssertionError();
        }
    }

    public void EliminarCita() {

        String eaeliminar = "nn";

        if (eaeliminar.equalsIgnoreCase("nutricionista")) {
            eliminar(bayter, gomez, "nutricionista");
        }
        if (eaeliminar.equalsIgnoreCase("cardiologo")) {
            eliminar(medina, perez, "cardiologo");
        }
        if (eaeliminar.equalsIgnoreCase("pediatra")) {
            eliminar(botero, molina, "pediatra");
        }
        if (eaeliminar.equalsIgnoreCase("dermatologo")) {
            eliminar(aroca, camargo, "dermatologo");
        }
        if (eaeliminar.equalsIgnoreCase("medico general")) {
            eliminar(tellez, cochero, "medico general");
        }
    }

    public static void main(String[] args) throws IOException {
        
        
        Datos20 dd = new Datos20();
        dd.AsignarCita();
        dd.EliminarCita();
    }
}
