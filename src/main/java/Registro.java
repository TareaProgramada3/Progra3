
//import com.sun.istack.internal.NotNull;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named (value="Registro")
@RequestScoped

public class Registro {

    String [] lol= new String[6];
    String edad;
    String carrera;
    String direccion;
    String año;
    String telefono;
    String nombre;
    String apellido;
    String correo1;
    String correo2;
    String contraseña1;
    String contraseña2;
    String contraseña3;
    String imagen;

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
        
    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public String getCorreo1() {
        return correo1;
    }

    public void setCorreo1(String correo1) {
        this.correo1 = correo1;
    }

    public String getCorreo2() {
        return correo2;
    }

    public void setCorreo2(String correo2) {
        this.correo2 = correo2;
    }

    public String getContraseña1() {
        return contraseña1;
    }

    public void setContraseña1(String contraseña1) {
        this.contraseña1 = contraseña1;
    }

    public String getContraseña2() {
        return contraseña2;
    }

    public void setContraseña2(String contraseña2) {
        this.contraseña2 = contraseña2;
    }

    public String getContraseña3() {
        return contraseña3;
    }

    public void setContraseña3(String contraseña3) {
        this.contraseña3 = contraseña3;
    }
    
    public void mensaje (){
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(this.año));
    }
    
    public void megalol(){
        lol[0]="maria";
        lol[1]="pepe";
        lol[2]="dani";
        lol[3]="jorge";
        lol[4]="kenneth";
        lol[5]="ares";
        int i=0;
        while(i<6){
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(lol[i]));
           i++;
        }
    }
}
