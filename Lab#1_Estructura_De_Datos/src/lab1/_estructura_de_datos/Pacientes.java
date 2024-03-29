
package lab1._estructura_de_datos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Pacientes {
    long cedula;
    String nombre,apellido,especialidadMedica, fecha;
    long medicoAsignado;
    
    public Pacientes(long ced, String nom, String ape, String esp, long med, String fec){
        this.nombre = nom;
        this.apellido = ape;
        this.cedula = ced;
        this.especialidadMedica = esp;
        this.fecha = fec;
        this.medicoAsignado = med;
    }
    
    public Pacientes(String cad){
        String[] rest = cad.split("~");
        this.cedula = (Long.parseLong(rest[0].trim()));
        this.nombre = (rest[1]);
        this.apellido =(rest[2]);
        this.especialidadMedica = (rest[3]);
        this.medicoAsignado = Long.parseLong(rest[4].trim());
        this.fecha = (rest [5]);   
    }
    
    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidadMedica() {
        return especialidadMedica;
    }

    public void setEspecialidadMedica(String especialidadMedica, ArchivoMedicos es) {
        this.especialidadMedica = especialidadMedica;
        List<String> especialidades = es.obEsp();
    }

    public long getMedicoAsignado() {
        return medicoAsignado;
    }

    public void setMedicoAsignado(long medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    } 
    
    public String getDatos(){
        return getCedula() +"~"+getNombre() +"~"+getApellido() +"~"+getEspecialidadMedica() +"~"+getMedicoAsignado() +"~"+getFecha();
    }
    
    public int getames(){
       String division[] = fecha.split("/");
       int ames;
       int mes = Integer.parseInt(division[1]);
       int an = Integer.parseInt(division[2]);
       ames = an*100 + mes;
     return ames;         
    }
    
    public Pacientes(){
        
    }
    
}
