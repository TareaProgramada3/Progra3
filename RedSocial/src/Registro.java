
import java.io.IOException;

public class Registro {

    String [] login= new String[10];
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
    baseDeDatos datos = new baseDeDatos();

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
    
    public void singUn() throws IOException{
        if(contraseña2==contraseña3){
            this.datos.almacenarFicherosDatosClientes(correo2, contraseña2, nombre, apellido, año, edad, direccion, telefono, carrera, imagen); 
            datos.leerFicherosClientes();
            datos.matrizUsuarios();
            datos.inicios();
        }
        
    }
    
    public void singIn() throws IOException{
        datos.leerFicherosClientes();
        datos.matrizUsuarios();
        datos.leerFicherosAmigos(correo1);
        this.login=datos.encuentreme(correo1);
        if (this.contraseña1==login[1]){
            segunda();
        }
    }
    
    public void segunda(){
        
        this.correo1=login[0];
        this.contraseña1=login[1];
        this.nombre=login[2];
        this.apellido=login[3];
        this.año=login[4];
        this.edad=login[5];
        this.direccion=login[6];
        this.telefono=login[7];
        this.carrera=login[8];
        this.imagen=login[9];
    }
    
}
