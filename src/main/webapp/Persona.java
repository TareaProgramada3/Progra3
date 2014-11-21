public class Persona{
    public String[] datos,amigos;

    public String[] getDatos(){
        return datos;
    }

    public void setDatos(String[] datos){
        this.datos = datos;
    }

    public String[] getAmigos(){
        return amigos;
    }

    public void setAmigos(String[] amigos){
        this.amigos = amigos;
    }

    public Persona(String[] datos, String[] amigos){
        this.datos = datos;
        this.amigos = amigos;
    }
}