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

    File archivoM = new File("ArchivoMedicos.txt");

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

            FileWriter fw = new FileWriter("ArchivoMedicos.txt", true);
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
            File f = new File("ArchivoMedicos.txt");
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
    public ArrayList<String> obEsp() {
        ArrayList<String> especialidades = new ArrayList<>();
        try {
            FileReader fr = new FileReader("ArchivoMedicos.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] c = linea.split("~");
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

    //CONSULTAR MEDICO (por cedula)
    public ArrayList<Medicos> Consultar(long c) {
        ArrayList<Medicos> m = new ArrayList<Medicos>();
        try {
            File f = new File("ArchivoMedicos.txt");
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
    public void Eliminar1(String el) {
        ArrayList<Medicos> m = new ArrayList<Medicos>();
        m = Leer();
        try {
            FileWriter fw = new FileWriter("ArchivoMedicos.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < m.size(); i++) {
                if (!(m.get(i).getNombre().equals(el))) {
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
            File ff = new File("ArchivoMedicos.txt");
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

    //Listar medicos por especialidad 
    public List<String> obMed(String es) {
        List<String> medicos = new ArrayList<>();
        try {
            File ff = new File("ArchivoMedicos.txt");
            FileReader fr = new FileReader(ff);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] c = linea.split("~");
                String nombreM = c[1].trim();
                String espe = c[2].trim();
                int cit = Integer.parseInt(c[4].trim());
                if (espe.equals(es)) {
                    if (cit <= 10) {
                        if (!medicos.contains(nombreM)) {
                            medicos.add(nombreM);
                        }
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return medicos;
    }
    //Agregar cita 
    public boolean AgregarC(String el) {
        ArrayList<Medicos> m = new ArrayList<Medicos>();
        m = Leer();
        boolean sw= false;
        try {
            FileWriter fw = new FileWriter("ArchivoMedicos.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < m.size(); i++) {
                if (!(m.get(i).getNombre().equals(el))) {
                    bw.write(m.get(i).getDatos() + "\n");
                }
                else {
                    int n = m.get(i).getCita();
                    if (n < 10){
                        m.get(i).setCita(n+1);
                        sw = true;
                    }
                    bw.write(m.get(i).getDatos() + "\n");
                }
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return sw;
    } 
    //Reiniciar citas
        public void reiniciar() {
        ArrayList<Medicos> m = new ArrayList<Medicos>();
        m = Leer();
        try {
            FileWriter fw = new FileWriter("ArchivoMedicos.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < m.size(); i++) {
                m.get(i).setCita(0);     
                bw.write(m.get(i).getDatos() + "\n");
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } 
    
    //Quitar una cita 
    //Agregar cita 
    public boolean Eliminar1(String el) {
        ArrayList<Medicos> m = new ArrayList<Medicos>();
        m = Leer();
        boolean sw= false;
        try {
            FileWriter fw = new FileWriter("ArchivoMedicos.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < m.size(); i++) {
                if (!(m.get(i).getNombre().equals(el))) {
                    bw.write(m.get(i).getDatos() + "\n");
                }
                else {
                    int n = m.get(i).getCita();
                    if (n < 10){
                        m.get(i).setCita(n+1);
                        sw = true;
                    }
                    bw.write(m.get(i).getDatos() + "\n");
                }
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return sw;
    } 
    
    
}
