import java.util.Scanner;
import Lista.*;

public class App {
    static Scanner read = new Scanner(System.in);
    static Pila pilaProducto1 = new Pila();
    static Pila pilaProducto2 = new Pila();

    public static void main(String[] args) throws Exception {
        int opcionProd, opcionGestion;
        do {
            opcionProd = menuProductos();
            if(opcionProd != 3){
                do {
                    opcionGestion = menuGestion();
                    switch (opcionGestion) {
                        case 1: agregar(opcionProd);
                            break;
                        case 2: retirar(opcionProd);
                            break;
                        case 3: consultarUltimo(opcionProd);
                            break;
                        case 4: imprimir(opcionProd);
                            break;
                        case 5: totalPaquetes(opcionProd);
                            break;
                        case 6: paquetesPermitidos();
                            break;
                    }
                } while (opcionGestion != 7);
            }
        } while (opcionProd != 3);
        read.close();
    }//main

    public static int menuProductos(){
        int respMenu = 0;
        boolean error=false;
        do {
            clear();
            error=false;
            System.out.println("Gestión de productos");
            System.out.println("Seleccione el producto que gestionará");
            System.out.println("1. Producto 1");
            System.out.println("2. Producto 2");
            System.out.println("3. Salir");
            try { 
                System.out.print("Opción: ");
                respMenu = read.nextInt();
            } catch (Exception e) {
                System.out.println("\nIngrese una opción válida");
                error = true;
                read.nextLine();
            }
        } while (respMenu < 1 || respMenu > 3 || error);
        return respMenu;
    }//menuProductos

    public static int menuGestion(){
        int respMenu = 0;
        boolean error=false;
        do {
            clear();
            error=false;
            System.out.println("Gestión de paquetes");
            System.out.println("1. Agregar paquete");
            System.out.println("2. Retirar paquete");
            System.out.println("3. Consultar el último paquete");
            System.out.println("4. Consultar todos los paquetes");
            System.out.println("5. Total de paquetes actuales");
            System.out.println("6. Total de paquetes permitidos");
            System.out.println("7. Regresar");
            try { 
                System.out.print("Opción: ");
                respMenu = read.nextInt();
            } catch (Exception e) {
                System.out.println("\nIngrese una opción válida");
                error = true;
                read.nextLine();
            }
        } while (respMenu < 1 || respMenu > 7 || error);
        return respMenu;
    }//menuGestion

    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }//clear

    public static void paquetesPermitidos(){
        clear();
        System.out.println("Paquetes permitidos");
        System.out.println("Número máximo: " + pilaProducto1.maxElementos());
        enter();
    }//paquetes permitidos

    public static void totalPaquetes(int opcionProd){
        clear();
        System.out.println("Total de paquetes actuales");
        if(opcionProd == 1){
            System.out.println("Cantidad: " + pilaProducto1.numElementos());
        }else{
            System.out.println("Cantidad: " + pilaProducto2.numElementos());
        }
        enter();
    }

    public static void enter(){
        Scanner continuar = new Scanner(System.in);
        continuar.useDelimiter("\n");
        System.out.print("Presione Enter para continuar");
        continuar.next();
    }//enter

    public static void agregar(int opcionProd){
        String codigo, descripcion;
        clear();
        System.out.println("Agregar paquetes del producto " + opcionProd);
        System.out.println("Agregue los datos");
        System.out.print("Código: ");
        codigo = read.next();
        System.out.print("Descripción: ");
        descripcion = read.next();
        if(opcionProd == 1){
            pilaProducto1.agregar(codigo, descripcion);
        }else{
            pilaProducto2.agregar(codigo, descripcion);
        }
        enter();
    }//agregar

    public static void imprimir(int opcionProd){
        clear();
        System.out.println("Lista de paquetes del producto " + opcionProd);
        if(opcionProd == 1){
            pilaProducto1.imprimir();
        }else{
            pilaProducto2.imprimir();
        }
        enter();
    }//imprimir

    public static void retirar(int opcionProd){
        clear();
        System.out.println("Retirar el último paquete");
        if (opcionProd == 1) {
            pilaProducto1.retirar();
        } else {
            pilaProducto2.retirar();
        }
        enter();
    }//retirar

    public static void consultarUltimo(int opcionProd){
        clear();
        System.out.println("Consultar el último paquete");
        if (opcionProd == 1) {
            pilaProducto1.valorCima();
        } else {
            pilaProducto2.valorCima();
        }
        enter();
    }//retirar

}//class