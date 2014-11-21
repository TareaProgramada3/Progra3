import java.util.*;
import java.io.*;

 /**
 * lee, guarda, extra informacion de los .txt 
 */
public class baseDeDatos 
{ 
    public BufferedReader almacenadorTemporalDeLectura;
    public File fichero;
    public FileReader lectorDeFichero;
    public FileWriter escritorDeArchivos;
    public PrintWriter impresorDeArchibos;
    String [] generica = new String [10];
    String []  amigos = new String [999];
     
    public baseDeDatos()
    {
        this.almacenadorTemporalDeLectura = null;
        this.fichero = null;
        this.lectorDeFichero = null;
        this.escritorDeArchivos = null;
        this.impresorDeArchibos = null;
    }
    
    public void leerFicherosClientes() throws FileNotFoundException, IOException
    {        
        this.fichero = new File ("src/base de datos/cliente.txt");
        this.lectorDeFichero = new FileReader (this.fichero);
    }
     
    public void ArrogloAmigos() throws IOException
    {
        this.almacenadorTemporalDeLectura = new BufferedReader(this.lectorDeFichero);
        String linea = ""; 
        int aux=0;
        while((linea=this.almacenadorTemporalDeLectura.readLine()) != null)
        {
            char[] arregloLinea = linea.toCharArray();
            linea="";
            for(int ind = 0; ind < arregloLinea.length - 1 ; ind++ )
            {
                
                if(arregloLinea[ind]=='#')
                {
                    //falta crear aqui el obj nodo del grafo
                    break;
                }
                if(arregloLinea[ind] != ',')
                {
                    linea = linea + arregloLinea[ind] + "";
                }
                else
                {
                    this.generica[aux]=(linea);
                    linea="";
                    aux++;
                }    
            }
        }
        this.lectorDeFichero.close();
    }
    public void ArregloUsuarios() throws IOException
    {
        this.almacenadorTemporalDeLectura = new BufferedReader(this.lectorDeFichero);
        String linea = ""; 
        int aux=0;
        while((linea=this.almacenadorTemporalDeLectura.readLine()) != null)
        {
            char[] arregloLinea = linea.toCharArray();
            linea="";
            for(int ind = 0; ind < arregloLinea.length - 1 ; ind++ )
            {
                
                if(arregloLinea[ind]=='#')
                {
                    //falta crear aqui el obj nodo del grafo
                    break;
                }
                if(arregloLinea[ind] != ',')
                {
                    linea = linea + arregloLinea[ind] + "";
                }
                else
                {
                    this.generica[aux]=(linea);
                    linea="";
                    aux++;
                }    
            }
        }
        this.lectorDeFichero.close();    
    }
    
    public void almacenarFicherosClientes(String correo, String contra) throws IOException{
        String aux="";
        aux = correo +","+ contra+",#";
        this.escritorDeArchivos = new FileWriter("src/main/java/Base de datos/Registrados.txt",true);
        this.impresorDeArchibos = new PrintWriter(this.escritorDeArchivos);
        this.impresorDeArchibos.println(aux);
        this.escritorDeArchivos.close();
    }
    
    /**
    * almacena en .txt la prioridad , fecha y hora de atencion de los clientes
    */
    public void almacenarFicherosDatosClientes(String correo, String contra, String nombre, String apellido, String año, String edad, String direccion, String telefono, String carrera, String foto) throws IOException
    {
        String aux= correo +","+contra+","+nombre+","+apellido+","+año+","+edad+","+direccion+","+telefono+","+carrera+","+foto+",#";
        this.escritorDeArchivos = new FileWriter("src/main/java/Base de datos/datosClientes.txt",true);
        this.impresorDeArchibos = new PrintWriter(this.escritorDeArchivos);
        this.impresorDeArchibos.println( aux );
        this.escritorDeArchivos.close();
    }
}