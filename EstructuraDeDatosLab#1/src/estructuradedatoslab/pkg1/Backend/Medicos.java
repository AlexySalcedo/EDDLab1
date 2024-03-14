
package estructuradedatoslab.pkg1.Backend;

public class Medicos {  
    long  identificacion,telefono;
    String nombre, especialidad;
    int cita;
    
    public Medicos(long ide, String nom, String esp, long tel){
        this.nombre = nom;
        this.identificacion = ide;
        this.especialidad = esp;
        this.telefono = tel;
        this.cita = 0;
    }
    public Medicos(String cadena){
        String[] rest = cadena.split("~");
        this.identificacion = (Long.parseLong(rest[0].trim()));
        this.nombre = (rest[1]);
        this.especialidad = (rest[2]);
        this.telefono = (Long.parseLong(rest[3].trim()));
        this.cita = (Integer.parseInt(rest[4].trim()));
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
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

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public int getCita() {
        return cita;
    }

    public void setCita(int cita) {
        this.cita = cita;
    }
    
    public String getDatos(){
        return getIdentificacion() + "~" + getNombre() + "~" + getEspecialidad() + "~" + getTelefono() + "~" + getCita();
    }
    
    public Medicos(){
    }
    
}
