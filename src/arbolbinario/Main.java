

package arbolbinario;

class NodoArbol {
    NodoArbol nodoIzquierdo;
    int datos;
    NodoArbol nodoDerecho;
    
    public NodoArbol (int datosNodo){
        datos=datosNodo;
        nodoIzquierdo=nodoDerecho=null;
    }
    
    public synchronized void insertar (int valorInsertar){
        if (valorInsertar<datos){
            if (nodoIzquierdo==null)
                nodoIzquierdo=new NodoArbol(valorInsertar);
            else
                nodoIzquierdo.insertar(valorInsertar);
        }
        else if (valorInsertar>= datos) {
            if (nodoDerecho==null)
                nodoDerecho=new NodoArbol(valorInsertar);
            else
                nodoDerecho.insertar(valorInsertar);
           }
    }

    public void busqueda(int valorBuscar)
    {
        if(valorBuscar<datos)
        {
            if(nodoIzquierdo==null)
            {
                System.out.println("El nodo no se encuentra en el árbol");
            }
            else
                nodoIzquierdo.busqueda(valorBuscar);
        }
        else
        {
            if(valorBuscar>datos)
            {
                if(nodoDerecho==null)
                {
                    System.out.println("El nodo no se encuentra en el árbol");
                }
                else
                    nodoDerecho.busqueda(valorBuscar);
            }
            else
                    System.out.println("El nodo se encuentra en el árbol");
        }
    }

    public void obtenermenor(NodoArbol nodo){
        if (nodo==null) return;
        else {
            if (nodo.nodoIzquierdo!=null){
                obtenermenor(nodo.nodoIzquierdo);}
                else {
                    System.out.println("el menor es "+nodo.datos);
                }
            }
    }

}

class Arbol {
    private NodoArbol raiz;

    public Arbol(){
        raiz=null;
    }

    public synchronized void buscarNodo( int valorBuscar){
        if (raiz!=null) raiz.busqueda(valorBuscar);
    }

    public void menor(){
        raiz.obtenermenor(raiz);
    }
    public synchronized void insertarNodo (int valorInsertar) {
        if (raiz==null)
            raiz=new NodoArbol (valorInsertar);
        else
            raiz.insertar(valorInsertar);
    }

    public synchronized void recorridoPreorden() {
        hacerPreorden(raiz);
    }

    private void hacerPreorden(NodoArbol nodo){
        if (nodo==null)
            return;
        System.out.print(nodo.datos+"  ");
        hacerPreorden(nodo.nodoIzquierdo);
        hacerPreorden(nodo.nodoDerecho);
    }

    public synchronized void recorridoPostorden() {
        hacerPostorden(raiz);
    }

     private void hacerPostorden(NodoArbol nodo){
        if (nodo==null) return;
        hacerPostorden(nodo.nodoIzquierdo);
        hacerPostorden(nodo.nodoDerecho);
        System.out.print(nodo.datos+"  ");
    }

    public synchronized void recorridoInorden() {
        hacerInorden(raiz);
    }

    private void hacerInorden(NodoArbol nodo){
        if (nodo==null) return;
        hacerInorden(nodo.nodoIzquierdo);
        System.out.print(nodo.datos+"  ");
        hacerInorden(nodo.nodoDerecho);
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Arbol arbol= new Arbol();
        int  valor1;
        String dato;
        System.out.println("");
        System.out.println("Insertando los valores: ");
        for (int i=1; i<=25; i++){
         //dato =javax.swing.JOptionPane.showInputDialog("valor del árbol "+i+" ");
        //valor1=Integer.parseInt(dato);

           valor1=(int) (Math.random()*100);
           System.out.print(valor1+"  ");
           arbol.insertarNodo(valor1);
        }

        System.out.println("\n\n Recorrido preorden ");
        arbol.recorridoPreorden();
        //dato =javax.swing.JOptionPane.showInputDialog("Nodo a buscar ");
        //valor1=Integer.parseInt(dato);
        //arbol.buscarNodo(valor1);
        System.out.println("\n\n Recorrido inorden");
        arbol.recorridoInorden();
        System.out.println("\n\n Recorrido postorden ");
        arbol.recorridoPostorden();
        System.out.println(" ");
        arbol.menor();
        /*dato =javax.swing.JOptionPane.showInputDialog("Nodo a buscar ");
        valor1=Integer.parseInt(dato);
        arbol.buscarNodo(valor1);*/
        System.out.println(" ");
    }

}
