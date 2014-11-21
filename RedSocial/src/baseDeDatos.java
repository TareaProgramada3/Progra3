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
    String [] generica = new String [400];
    String [][] usuarios = new String[200][10];
    String [][] amigosDeUsuarios =new String[200][10];
    int sizeAmigos,sizeUsuarios;

    grafosRedSocial grafo;

     
    public baseDeDatos()
    {
        grafo=new grafosRedSocial();
        this.almacenadorTemporalDeLectura = null;
        this.fichero = null;
        this.lectorDeFichero = null;
        this.escritorDeArchivos = null;
        this.impresorDeArchibos = null;
        
    }
    
    public String[] encuentreme(String correo){
        return grafo.encuentreme(correo);
    }
    
    public void leerFicherosClientes() throws FileNotFoundException, IOException
    {        
        this.fichero = new File ("Documents\\NetBeansProjects\\TP3\\src\\main\\java\\Base de datos\\datosClientes.txt");
        this.lectorDeFichero = new FileReader (this.fichero);
    }
    
    public void leerFicherosAmigos(String nombre) throws FileNotFoundException, IOException
    {        
        this.fichero = new File ("Documents\\NetBeansProjects\\TP3\\src\\main\\java\\Base de datos\\"+nombre+".txt");
        this.lectorDeFichero = new FileReader (this.fichero);
    }
    
    public void inicios() throws IOException
    {
        this.almacenadorTemporalDeLectura = new BufferedReader(this.lectorDeFichero);
        grafo.agregar(generica);
        this.grafo.agregar(this.usuarios[0]);
        this.grafo.getNodo(0).agregarRelacion(this.usuarios[0]);
        this.lectorDeFichero.close();
    }
     
    public void matrizUsuarios() throws IOException
    {
        this.almacenadorTemporalDeLectura = new BufferedReader(this.lectorDeFichero);
        String linea = ""; 
        int indicador=0;
        while((linea=this.almacenadorTemporalDeLectura.readLine()) != null)
        {
            char[] arregloLinea = linea.toCharArray();
            linea="";
            int aux=0;
            for(int ind = 0; ind < arregloLinea.length - 1 ; ind++ )
            {
                
                if(arregloLinea[ind]=='#')
                {
                    this.usuarios[indicador]=generica;
                    this.sizeUsuarios++;
                    indicador++;
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
        int ind=0;
        while((linea=this.almacenadorTemporalDeLectura.readLine()) != null)
        {
            generica[ind]=linea;
            ind++;
            generica[ind]=linea;
            ind++;
        }
        int j=0;
        int i=0;
        while(j<ind){
            if(this.usuarios[i][2]==generica[j] && this.usuarios[i][3]==generica[j+1]){
                j=j+2;
                this.grafo.agregar(this.usuarios[aux]);
                this.grafo.getNodo(aux).agregarRelacion(this.usuarios[i]);
            }
            i++;
            if (i==this.sizeUsuarios){
                i=0;
            }
        }
        this.lectorDeFichero.close();    
    }
    
    public void almacenarFicherosClientes(String nombre, String direccion) throws IOException{
        
        this.escritorDeArchivos = new FileWriter("Documents\\NetBeansProjects\\TP3\\src\\main\\java\\Base de datos\\"+direccion+".txt",true);
        this.impresorDeArchibos = new PrintWriter(this.escritorDeArchivos);
        this.impresorDeArchibos.println(nombre);
        this.escritorDeArchivos.close();
    }
    
    /**
    * almacena en .txt la prioridad , fecha y hora de atencion de los clientes
    */
    public void almacenarFicherosDatosClientes(String correo, String contra, String nombre, String apellido, String año, String edad, String direccion, String telefono, String carrera, String foto) throws IOException
    {
        String aux= correo +","+contra+","+nombre+","+apellido+","+año+","+edad+","+direccion+","+telefono+","+carrera+","+foto+",#";
        this.escritorDeArchivos = new FileWriter("Documents\\NetBeansProjects\\TP3\\src\\main\\java\\Base de datos\\datosClientes.txt",true);
        this.impresorDeArchibos = new PrintWriter(this.escritorDeArchivos);
        this.impresorDeArchibos.println( aux );
        this.escritorDeArchivos.close();
    }
}
