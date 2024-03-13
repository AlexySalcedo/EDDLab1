package datos20;

import java.io.FileWriter;
import java.io.IOException;

class Medicos {

    String nombre, especialidad;
    int identificacion, telefono;
    int cita;
    
    int bayter = 0, gomez = 0, medina = 0, perez = 0, botero = 0, molina = 0, aroca = 0, camargo = 0, tellez = 0, cochero = 0;

    public Medicos() {
    }

    public Medicos(String nom, String esp, int ide, int tel) {
        this.nombre = nom;
        this.especialidad = esp;
        this.identificacion = ide;
        this.telefono = tel;
        this.cita = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCita() {
        this.cita = 0;
    }

    public int getCita() {
        return cita;
    }

    public String getDatosM() {
        return getIdentificacion() + " , " + getNombre() + " , " + getEspecialidad() + " , " + getTelefono() + " , " + getCita();
    }

    public void crearArchivo() {
        try {
            FileWriter crear = new FileWriter("medicos.txt");

            crear.write("Dr. Jorge Bayter , Nutricionista , 134563 , 3008157670 , " + bayter + "\n");
            crear.write("Dra. Maria Gomez, Nutricionista, 123458 , 3156654742 , " + gomez + "\n");
            crear.write("Dr. Marlon Medina, Cardiologo, 159753 , 3008156770 , " + medina + "\n ");
            crear.write("Dra. Estefania Perez, Cardiologa, 157953, 3124867595 , " + perez + "\n");
            crear.write("Dra. Sandra Botero, Pediatra, 174963, 3129957486 , " + botero + "\n");
            crear.write("Dra. Mariana Molina, Pediatra, 186245, 3227548695 , " + molina + "\n");
            crear.write("Dra. Maria Aroca, Dermatologa, 196324, 3778459682 , " + aroca + "\n");
            crear.write("Dr. Nicolas Camargo, Dermatologo, 105769, 3554879695 , " + camargo + "\n");
            crear.write("Dr. Andres Tellez, Medico General, 106547, 3009457276 , " + tellez + "\n");
            crear.write("Dra. Sofia Cochero, Medico General, 165789, 3221459685 , " + cochero + "\n");

            System.out.println("Archivo de médicos creado exitosamente.");
            crear.close();

        } catch (IOException ex) {
            System.out.println("ERROR CREANDO ARCHIVO");
        }

    }
}
