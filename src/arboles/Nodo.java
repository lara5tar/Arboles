package arboles;

public class Nodo {
    
    int num = 0;
    Nodo izq = null;
    Nodo der = null;
    
    public Nodo(int num){
        this.num = num;
    }

    @Override
    public String toString() {
        return num + "";
    }
    
    
}
