//https://fbcdn-sphotos-h-a.akamaihd.net/hphotos-ak-xpf1/t31.0-8/s960x960/10264179_558098297655263_5031121342751177084_o.jpg
public class Grafos<E> {
    public static Lista<Nodo> listaNodos;
    public static class Nodo<E>{
        private E dato;
        private Lista<Nodo<E>> lista;
        public Nodo siguiente;
        public Nodo anterior;

        public E getDato() {
            return dato;
        }

        public void setDato(E dato) {
            this.dato = dato;
        }

        public Lista<Nodo<E>> getLista() {
            return lista;
        }
        public Nodo(E dato){
            if (listaNodos.size == 0){
                this.anterior = null;
            }
            else{
                anterior = listaNodos.ultimoNodo;
            }
            this.dato = dato;
            this.lista = new Lista<Nodo<E>> ();
            this.siguiente = null;
        }
        public void agregarRelacion(Nodo n){
            this.lista.agregar(n);
            n.lista.agregar(this);
        }
        public void eliminarRelacion(Nodo n){
            this.lista.eliminar(n);
            n.lista.eliminar(this);
        }
        public Nodo obtenerSiguiente(){
            return siguiente;
        }
        public Nodo obtenerAnterior(){
            return anterior;
        }
        public void establecerSiguiente(Nodo siguiente){
            this.siguiente = siguiente;
        }
        public void establecerAnterior(Nodo anterior){
            this.anterior = anterior;
        }
    }
    public static class Lista<E> {
        
        public Nodo primerNodo;
        public Nodo ultimoNodo;
        private int size = 0;
        public Lista()
        {
            this.primerNodo = null;
            this.ultimoNodo = null;
        }
        public Nodo buscar(Nodo n){
            Nodo aux = primerNodo;
            int i = 0;
            while (i < size){
                if (aux.getDato() == n.getDato()){
                    return aux;
                }
                aux = aux.siguiente;
                i ++;
            }
            return null;
        }
        public void agregar(Nodo nodo)
        {
            if (this.primerNodo == null)
            {
                this.primerNodo = nodo;
                this.ultimoNodo = nodo;
            }
            else
            {
                this.ultimoNodo.establecerSiguiente(nodo);
                this.ultimoNodo = nodo;       
            }

            this.size++;
        }
        public int size()
        {
            return this.size;
        }
        public void vaciar(){
            while (size > 0){
                ultimoNodo = ultimoNodo.anterior;
                ultimoNodo.siguiente = null;
                size --;
            }
        }
        public void eliminar(Nodo f){
            if (size == 1){
                primerNodo = ultimoNodo = null;
            }
            else{
                if ((f.anterior == null)){
                    primerNodo = primerNodo.siguiente;
                    primerNodo.anterior = null;
                }
                else if((f.siguiente == null)){
                    ultimoNodo = ultimoNodo.anterior;
                    ultimoNodo.siguiente = null;
                }
                else{
                    f.anterior.siguiente = f.siguiente;
                    f.siguiente.anterior = f.anterior;
                }
                
            }
            size --;
    }
    public boolean esVacia(){
        return primerNodo == null;
    }
    }
    Grafos(){
        listaNodos = new Lista();
    }
    public void agregarNodo(E n){
        Nodo f = new Nodo(n);
        listaNodos.agregar(f);
    }
    public void agregarRelacion(Nodo n1, Nodo n2){
        n1.agregarRelacion(n2);
        n2.agregarRelacion(n1);
    }
    public void eliminarRelacion(Nodo n1, Nodo n2){
        n1.eliminarRelacion(n2);
        n2.eliminarRelacion(n1);
    }
    public static int buscarNodo(Nodo n){
        Nodo r = listaNodos.buscar(n);
        if(r == null){
            return -1;
        }
        return 1;
    }
    public void eliminarNodo(Nodo nodo){
        Nodo r = listaNodos.buscar(nodo);
        if(r != null){
            listaNodos.eliminar(r);
        }
    }
    public int buscarRelacion(Nodo n1, Nodo n2){
        Nodo nodo1 = listaNodos.buscar(n1);
        Nodo nodo2 = listaNodos.buscar(n2);
        Nodo aux = nodo1.lista.primerNodo;
        int i = 0;
        while (i < nodo1.lista.size){
            if (aux.getDato() == nodo2.getDato()){
                return i;
            }
            aux = aux.siguiente;
            i ++;
        }
        return -1;
    }
    public static void main(String[] args) {
        Grafos d = new Grafos();
        d.agregarNodo(34);
        d.agregarNodo(54);
        d.eliminarNodo(new Nodo(34));
        int g = d.buscarNodo(new Nodo(34));
        System.out.println(g);
    }
}