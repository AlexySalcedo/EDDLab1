
package lab1._estructura_de_datos;

import java.time.LocalDate;


public class Pacientes {
    long cedula;
    String nombre,apellido,especialidadMedica,medicoAsignado, fecha;
    
    public Pacientes(long ced, String nom, String ape, String esp, String med, String fec){
        this.nombre = nom;
        this.apellido = ape;
        this.cedula = ced;
        this.especialidadMedica = esp;
        String comprobarFecha[] = fecha.split("/");
        LocalDate.of(Integer.parseInt(comprobarFecha[2]), Integer.parseInt(comprobarFecha[1]), Integer.parseInt(comprobarFecha[0]));
        this.fecha = fec;
        this.medicoAsignado = med;
    }
    
    public Pacientes(String cad){
        String[] rest = cad.split("~");
        this.cedula = (Long.parseLong(rest[0].trim()));
        this.nombre = (rest[1]);
        this.apellido =(rest[2]);
        this.especialidadMedica = (rest[3]);
        this.medicoAsignado = (rest [4]);
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

    public void setEspecialidadMedica(String especialidadMedica) {
        this.especialidadMedica = especialidadMedica;
    }

    public String getMedicoAsignado() {
        return medicoAsignado;
    }

    public void setMedicoAsignado(String medicoAsignado) {
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
       LocalDate fa = LocalDate.now();
       int ames;
       
       
     return ames;         
    }
    
    public Pacientes(){
        
    }
    
}
