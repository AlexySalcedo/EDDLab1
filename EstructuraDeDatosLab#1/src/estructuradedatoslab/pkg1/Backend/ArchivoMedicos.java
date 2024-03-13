package estructuradedatoslab.pkg1.Backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArchivoMedicos {

    File archivoM = new File("C:\\ArchivoMedicos.txt");

    //CREAR ARCHIVO MEDICOS
    public void crearArchivoM() {
        try {
            archivoM.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //AGREGAR MEDICOS
    public void Añadir(Medicos med) {
        try {

            FileWriter fw = new FileWriter("C:\\ArchivoMedicos.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(med.getDatos() + "\n");
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //LEER MEDICOS
    public ArrayList<Medicos> Leer() {
        ArrayList<Medicos> m = new ArrayList<Medicos>();
        int i = 0;
        try {
            File f = new File("C:\\Temp\\ArchivoMedicos.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                Medicos med = new Medicos(linea);
                m.add(med);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return m;
    }

    //ESPECIALIDADES
    public List<String> obEsp() {
        List<String> especialidades = new ArrayList<>();
        try {
            FileReader fr = new FileReader(archivoM);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] c = linea.split("-");
                    String especialidad = c[2].trim();
                    if (!especialidades.contains(especialidad)) {
                        especialidades.add(especialidad);
                    }                
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return especialidades;
    }

    //CONSULTAR MEDICO
    public ArrayList<Medicos> Consultar(long c) {
        ArrayList<Medicos> m = new ArrayList<Medicos>();
        int i = 0;
        try {
            File f = new File("C:\\Temp\\ArchivoMedicos.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                Medicos med = new Medicos(linea);
                if (med.getIdentificacion() == c) {
                    m.add(med);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return m;
    }

    //ELIMINAR LAS CITAS DE UN MEDICO
    public void Eliminar1(long el) {
        ArrayList<Medicos> m = new ArrayList<Medicos>();
        m = Leer();
        try {
            FileWriter fw = new FileWriter("C:\\Temp\\ArchivoMedicos.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < m.size(); i++) {
                if (m.get(i).getIdentificacion() != el) {
                    bw.write(m.get(i).getDatos() + "\n");
                }
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //ELIMINAR UNA CITA DE MEDICOS
    public void Eliminar2(long el1, String espe) {
        try {
            File ff = new File("C:\\Temp\\ArchivoMedicos.txt");
            FileWriter fw = new FileWriter(ff);
            BufferedWriter bw = new BufferedWriter(fw);
            List<String> l = new ArrayList<>();
            l = Files.readAllLines(Paths.get(ff.getPath()));
            for (String linea : l) {
                Medicos med = new Medicos();
                if (!(med.getIdentificacion() == el1 && med.getEspecialidad() == espe)) {
                    bw.write(linea + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //
    public ArrayList<Medicos> Medes(String es) {
        ArrayList<Medicos> m = new ArrayList<Medicos>();
        try {
            File f = new File("C:\\Temp\\ArchivoMedicos.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                Medicos med = new Medicos(linea);
                if (med.getEspecialidad() == es) {
                    m.add(med);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return m;
    }

    //

    public static void main(String[] args) {
        int n = 153;
        Medicos m1 = new Medicos();
        ArchivoMedicos am = new ArchivoMedicos();

        am.crearArchivoM();

        ArrayList<Medicos> m = new ArrayList<Medicos>();
        am.Eliminar1(n);
        m = am.Leer();
        for (int i = 0; i < m.size(); i++) {
            System.out.println(m.get(i).getDatos() + "-");
        }
    }

}
