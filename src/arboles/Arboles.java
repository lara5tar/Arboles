package arboles;

import java.util.LinkedList;

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


    //imprime en orden
    void imprimirorden(Nodo nodo) {
        if (nodo != null ) {
            imprimirorden(nodo.izq);
            System.out.println(nodo);
            imprimirorden(nodo.der);
        }
    }


    //imprime por nivel
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
        eliminar(raiz, 25);
    }

    Nodo eliminar(Nodo aux, int num) {
        if (num == -1) {
            if(aux.der != null){
                aux = eliminar(aux.der, -1);
            }
        } else if (aux == null) {
            System.out.println("No se encontro el numero...");
            return null;
        } else if (aux.num == num) {//aqui encuentra el nodo a eliminar...
            if (aux.izq != null) {
                if(aux.der == null){
                    return aux.izq;
                } else {
                    Nodo izq = aux.izq, der = aux.der;
                    aux = eliminar(aux.izq, -1); 
                    
                    Nodo hijor = aux.izq;
                    aux.izq = izq;
                    aux.der = der;
                    
                    while(izq.der != aux){
                        izq = izq.der;
                    }
                    
                    izq.der = hijor;
                    
                }// aqui termina
            } else if (aux.der != null) {
                return aux.der;
            } else {
                System.out.println("hoja");
                return null;
            }
        } else if (num < aux.num) { //estos dos metods buscan el nodo a eliminar
            aux.izq = eliminar(aux.izq, num);
        } else {
            aux.der = eliminar(aux.der, num);
        }
        return aux;
    }

}
/*
                Nodo nuevo = aux.izq.der;
                Nodo izq = aux.izq;
                Nodo der = aux.der;
                aux = eliminar(aux.izq, -1);
                Nodo izqder = aux.izq;
                aux.izq = izq;
                aux.der = der;
                aux.izq.der = nuevo;
                
                Nodo auxaux = aux.izq;
                while(auxaux.der != null){
                    auxaux = auxaux.der;
                }
                System.out.println(aux.der);
                System.out.println(auxaux);
                if(aux.der != null){
                    auxaux.der = izqder;
                }
                
                 */
