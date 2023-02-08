package arboles;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Arboles {

    Nodo raiz;

    public void insertar(int num) {
        if (raiz == null) {
            raiz = new Nodo(num);
        } else {
            insertar(raiz, num);
        }
    }

    Nodo insertar(Nodo aux, int num) {
        if (aux == null) {
            return new Nodo(num);
        } else if (num < aux.num) {
            aux.izq = insertar(aux.izq, num);
        } else {
            aux.der = insertar(aux.der, num);
        }
        return aux;
    }

    void imprimirorden(Nodo nodoizq, Nodo nododer) {
        if (nodoizq != null ) {
            System.out.print(nodoizq + " " + nododer + " ");
            imprimirorden(nodoizq.izq, nodoizq.der);

            imprimirorden(nododer.izq, nododer.der);
        } else if (nododer != null){
            
        }
    }
    
    
    void imprimir() {
        LinkedList<Nodo> cola = new LinkedList<Nodo>();
        
        if (raiz != null) {
            cola.add(raiz);
            
                while (!cola.isEmpty()) {
                    if (cola.getFirst().izq != null) {
                        cola.add(cola.getFirst().izq);
                    }

                    if (cola.getFirst().der != null) {
                        cola.add(cola.getFirst().der);
                    }

                    System.out.print(cola.poll().num + " ");
                    
                }
        }

        System.out.println("");

    }
    
    void eliminar(){
        
    }

}
