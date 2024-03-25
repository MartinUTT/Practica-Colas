package Lista;

public class Pila {
    int max = 4;
    int cima = 0;
    Paquete [] paquete = new Paquete[max];

    public Pila(){
        for (int i = 0; i < max; i++) {
            paquete[i] = new Paquete();
        }
    }//Constructor de Pila

    /* Cantidad máxima de elementos que se pueden agregar */
    public int maxElementos(){
        return max;
    }

    /* Cantidad de elementos agregados */
    public int numElementos(){
        return cima;
    }

    /* Saber si la pila esta llena */
    public boolean pilaLlena(){
        return cima >= max;
    }

    /* Saber si la pila esta vacia */
    public boolean pilaVacia(){
        return cima == 0;
    }

    /* Agregar valores a la pila */
    public void agregar(String codigo, String descripcion){
        if (pilaLlena()) {
            System.out.println("Escriba máxima, no se puede agregar más paquetes");
        }else{
            paquete[cima].setCodigo(codigo);
            paquete[cima].setDescripcion(descripcion);
            cima++;
        }
    }//agregar

    /* Retirar paquetes de la cima */
    public void retirar(){
        if (pilaVacia()) {
            System.out.println("No hay paquetes para retirar");
        } else {
            cima--;
            System.out.println("Paquete retirado");
            System.out.println("Código:         " + paquete[cima].getCodigo());
            System.out.println("Descripción:    " + paquete[cima].getDescripcion());
            paquete[cima].setCodigo(null);
            paquete[cima].setDescripcion(null);
        }
    }//retirar

    /* Imprimir lista de paquetes */
    public void imprimir(){
        if (pilaVacia()) {
            System.out.println("No hay paquetes para imprimir");
        } else {
            System.out.println("Código \t Descripción");
            for (int i = 0; i < cima; i++) {
                System.out.print(paquete[i].getCodigo());
                System.out.println("\t" + paquete[i].getDescripcion());
            }
        }
    }//imprimir

    /* Obtener el valor de la cima */
    public void valorCima(){
        if (pilaVacia()) {
            System.out.println("No hay paquetes para mostrar");
        } else {
            System.out.println("Código     : " + paquete[cima-1].getCodigo());
            System.out.println("Descripción: " + paquete[cima-1].getDescripcion());
        }
    }//valorCima
}//Class
