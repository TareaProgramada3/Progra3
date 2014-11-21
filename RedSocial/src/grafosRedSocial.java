public class grafosRedSocial {
    public Nodo[] grafo = new Nodo[100];
    public int sizeGrafo = 0;
    public int miPosicion=0;
    public int aux=0;
    public int Temporal=0;
    public int distancia=0;
    
    public class Nodo{
        public String[] usuario= new String[10];
        public String[][] amigos= new String[100][10]; 
        public int sizeNodo = 0;
        
        public Nodo(String[] usuario) {
            this.usuario = usuario;
        }
    
        public boolean sonAmigos(String nombre, String apellido){
            int i = 0;
            while (i<sizeNodo){
                if (this.amigos[i][2]==nombre && this.amigos[i][3]==apellido)
                    return true;
                i++;
            }
            return false;
        }
        
        public String[] getAmigo(String nombre, String apellido){
            int i = 0;
            String[] validation=new String[1];
            while (i<sizeNodo){
                if (this.amigos[i][2]==nombre && this.amigos[i][3]==apellido)
                    return this.amigos[i];
                i++;
            }
            validation[0]="null";
            return validation;
        }
        
        public void agregarRelacion(String[] amigo){
            this.amigos[this.sizeNodo]= amigo;
        }
    }
    
    public Nodo getNodo(int pos){
        return this.grafo[pos];
    }
    
    public void agregar(String[] persona){
        Nodo user = null;
        user.usuario=persona;
        this.grafo[this.sizeGrafo]=user;
        this.sizeGrafo++;
    }
    
    public String[] encuentreme(String correo){
        int i=0;
        String [] validation=new String [1];
        while(i<this.sizeGrafo){
            if(this.grafo[i].usuario[0]==correo){
                this.miPosicion=i;
                return grafo[i].usuario;
            }
            i++;
        }
        validation[0]="null";
        return validation;
    }
    
    public void encuentreme1(String correo){
        int i=0;
        while(i<this.sizeGrafo){
            if(this.grafo[i].usuario[0]==correo){
                this.miPosicion=i;
                break;
            }
            i++;
        }
    }
    
    public int distaciaAmistad(String nombre, String apellido){
        this.Temporal=this.miPosicion;
        if(this.grafo[this.miPosicion].sonAmigos(nombre, apellido)==true){
            return distancia;
        }
        else{
           
            int pos= this.Temporal;
            int j=0;
            while(this.grafo[this.miPosicion].sonAmigos(nombre, apellido)!=true){
                distancia=this.distancia+1; 
                int i=0;
                this.aux=this.grafo[this.miPosicion].sizeNodo;
                while(aux>i){
                        miPosicion=pos;
                        encuentreme1(grafo[miPosicion].amigos[i][0]);
                        if(grafo[miPosicion].sonAmigos(nombre, apellido)==true){
                            return distancia;
                        }
                        i++;
                }
                miPosicion=pos;
                encuentreme1(grafo[miPosicion].amigos[j][0]);
                j++;
                pos=miPosicion;
                if(j==30){
                    return 3;
                }
            }
            return -1;
        }
    }
    
}