package Lista;

public class Pila {
    int max = 5;
    int cima = 0;
    int num =0;
    Paquete [] paquete = new Paquete[max];
    Clasificacion [] clasificacion = new Clasificacion[max];

    public Pila(){
        for (int i = 0; i < max; i++) {
            paquete[i] = new Paquete();
            clasificacion[i] = new Clasificacion();
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
            System.out.println("Estiba máxima, no se puede agregar más vehículos");
        }else{
            paquete[cima].setCodigo(codigo);
            paquete[cima].setDescripcion(descripcion);
            cima++;
        }
    }//agregar

    public void agregarNombreClasificacion(String nombre){
        if (pilaLlena()) {
            System.out.println("Estiba máxima, no se puede agregar más vehículos");
        }else{
            clasificacion[num].setNombreClasificacion(nombre);
            num++;
        }
    }//agregarNombreClasificacion

    /* Retirar paquetes de la cima */
    public Paquete retirar() {
        if (pilaVacia()) {
            System.out.println("No hay vehículos para retirar");
            return null;
        } else {
            cima--;
            Paquete paqueteRetirado = paquete[cima];
            paquete[cima] = new Paquete(); 
            return paqueteRetirado;
        }
    }
    

    /* Imprimir lista de paquetes */
    public void imprimir(){
        if (pilaVacia()) {
            System.out.println("No hay vehículos para imprimir");
        } else {
            System.out.println("\nCódigo \t\t\t Descripción\n");
            for (int i = 0; i < cima; i++) {
                System.out.printf("%-25s" ,paquete[i].getCodigo());
                System.out.printf("%-20s" , paquete[i].getDescripcion());
                System.out.println(" ");
            }
        }
    }//imprimir

    public void imprimirVehiculosClasificacion() {
        System.out.println("\nClasificación   Vehículos Retirados\n");
        for (int i = 0; i < max; i++) {
            System.out.printf("  %-22s %-25d\n", clasificacion[i].getNombreClasificacion(), clasificacion[i].getNumVehiculo());
        }
    }

    /* Obtener el valor de la cima */
    public void valorCima(){
        if (pilaVacia()) {
            System.out.println("No hay vehículos para mostrar");
        } else {
            System.out.println("Código           : " + paquete[cima-1].getCodigo());
            System.out.println("Descripción      : " + paquete[cima-1].getDescripcion());
            System.out.println("Número en la pila: " + cima);
        }
    }//valorCima

    public void numRetirados(int num){
        clasificacion[num-1].setNumVehiculo(clasificacion[num-1].getNumVehiculo()+1);
    }//numRetirados

}//Class
