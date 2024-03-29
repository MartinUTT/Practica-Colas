/*
    Armenta Telles Jesús Manuel 
    Contreras Rangel Martin 
    Diaz Escalante José Ángel 
    Farrera Martinez Ana Karen 

    Fecha de entrega: 31 de Marzo 2024
    Cuatrimestre y grupo: 4A
    Número y nombre del ejercicio: 1. Fundición de carros
 */

import java.util.Scanner;
import Lista.*;

public class App {
    static Scanner read = new Scanner(System.in);
    static Scanner readString = new Scanner(System.in);
    static Pila clasificacion1 = new Pila();
    static Pila clasificacion2 = new Pila();
    static Pila clasificacion3 = new Pila();
    static Pila clasificacion4 = new Pila();
    static Pila clasificacion5 = new Pila();
    static int clasificacion;
    static String descripcion, codigo;
    static Pila pilaClasificacion;
    static char repetir;
    static boolean error = false;
    static Pila nombreClasificacion = new Pila();

    public static void main(String[] args) {
        readString.useDelimiter("\n");
        int opcion;
        nombreClasificacion.agregarNombreClasificacion("Compactos");
        nombreClasificacion.agregarNombreClasificacion("Camionetas");
        nombreClasificacion.agregarNombreClasificacion("Vagonetas");
        nombreClasificacion.agregarNombreClasificacion("Camiones");
        nombreClasificacion.agregarNombreClasificacion("Autobuses");

        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    ingresarVehiculo();
                    break;
                case 2:
                    retirarVehiculo();
                    break;
                case 3:
                    vehiculosPorClasificacion();
                    break;
                case 4:
                    vehiculosTotales();
                    break;
                case 5:
                    vehiculosRetirados();
                    break;
                case 6:
                    salir();
                    break;
            }
        } while (opcion != 6);
        read.close();
    }

    public static int menu(){
        int respMenu = 0;
        boolean error=false;
        do {
            clear();
            error=false;
            System.out.println("Fundición de vehículos\n");
            System.out.println("|----------------------------------------|");
            System.out.println("| Opción |          Descripción          |");
            System.out.println("|----------------------------------------|");
            System.out.println("|   1    |   Ingresar vehículo           |");
            System.out.println("|   2    |   Retirar vehículo            |");
            System.out.println("|   3    |   Vehículos por clasificación |");
            System.out.println("|   4    |   Vehículos totales           |");
            System.out.println("|   5    |   Vehículos retirados         |");
            System.out.println("|   6    |   Salir                       |");
            System.out.println("------------------------------------------");
            try { 
                System.out.print("Opción: ");
                respMenu = read.nextInt();
            } catch (Exception e) {
                System.out.println("\nIngrese una opción válida");
                enter();
                error = true;
                read.nextLine();
            }
        } while (respMenu < 1 || respMenu > 6 || error);
        return respMenu;
    }//menu

    public static void ingresarVehiculo() {
        clear();
        System.out.println("\n\t\tIngresar Vehículo");
        System.out.println(" Solamente se pueden apilar 5 vehículos por pila\n");
        do {
            error=false;
            try {
                System.out.print("Ingrese la clasificación del vehículo (1-5): ");
                clasificacion = read.nextInt();
            } catch (Exception e) {
                error = true;
                read.next();
            }
        } while (clasificacion>5 || clasificacion<1 || error);
        pilaClasificacion = obtenerPila(clasificacion);
        if (pilaClasificacion.pilaLlena()) {
            System.out.println("No hay espacio disponible en esta clasificación.");
            enter();
            clear();
            System.out.println("Datos de la pila llena");
            pilaClasificacion.imprimir();
            System.out.println(" ");
            enter();
        }else{
            System.out.print("Ingrese el código del vehículo: ");
            codigo = readString.nextLine();
            System.out.print("Ingrese el descripción del vehículo: ");
            descripcion = readString.nextLine();
            pilaClasificacion.agregar(codigo, descripcion);
            System.out.println("Vehículo agregado a la clasificación " + clasificacion + ". Número en la pila: " + pilaClasificacion.numElementos());
            do {
                System.out.print("\nDesea registrar otro vehículo: S/N ");
                repetir = read.next().toUpperCase().charAt(0);
            } while (repetir != 'S' && repetir != 'N');
            if (repetir == 'S') {
                ingresarVehiculo();
            } 
        }
    }

    public static void retirarVehiculo() {
        clear();
        System.out.println("\n\t\tRetirar Vehículo");
        do {
            error=false;
            try {
                System.out.print("Ingrese la clasificación del vehículo (1-5): ");
                clasificacion = read.nextInt();
            } catch (Exception e) {
                error = true;
                read.next();
            }
        } while (clasificacion>5 || clasificacion<1 || error);
        pilaClasificacion = obtenerPila(clasificacion);
        if (pilaClasificacion.pilaVacia()) {
            System.out.println("No hay vehículos en esta clasificación.");
            enter();
        }else{
            do {
                System.out.println(" ");
                pilaClasificacion.valorCima();
                System.out.print("\nSeguro que desea retirar este vehículo: S/N ");
                repetir = read.next().toUpperCase().charAt(0);
            } while (repetir != 'S' && repetir != 'N');
            if (repetir == 'S') {
                System.out.println("Vehículo retirado de la clasificación " + clasificacion);
                pilaClasificacion.retirar();
                //vehiculosRetirado(clasificacion);
                nombreClasificacion.numRetirados(clasificacion);
                do {
                    System.out.print("\nDesea retirar otro vehículo: S/N ");
                    repetir = read.next().toUpperCase().charAt(0);
                } while (repetir != 'S' && repetir != 'N');
                if (repetir == 'S') {
                    retirarVehiculo();
                } 
            }
        }
    }

    public static void vehiculosPorClasificacion() {
        clear();
        System.out.println("\n\t\tVehículos por clasificación:");
        do {
            error=false;
            try {
                System.out.print("Ingrese la clasificación del vehículo (1-5): ");
                clasificacion = read.nextInt();
            } catch (Exception e) {
                error = true;
                read.next();
            }
        } while (clasificacion>5 || clasificacion<1 || error);
        pilaClasificacion = obtenerPila(clasificacion);
        if (pilaClasificacion == null) {
            System.out.println("Clasificación inválida.");
            enter();
        }else{
            pilaClasificacion.imprimir();
            do {
                System.out.print("\nDesea consultar otra clasificación: S/N ");
                repetir = read.next().toUpperCase().charAt(0);
            } while (repetir != 'S' && repetir != 'N');
            if (repetir == 'S') {
                vehiculosPorClasificacion();
            } 
        }
    }

    public static void vehiculosTotales() {
        clear();
        System.out.println("\n\t\tVehículos totales por clasificación:");
        System.out.println("------------------------------------");
        System.out.println("| Clasificación   |    Vehículos   |");
        System.out.println("|-----------------|----------------|");
        System.out.printf("|    Compactos    |        %d       |\n", clasificacion1.numElementos());
        System.out.printf("|    Camionetas   |        %d       |\n", clasificacion2.numElementos());
        System.out.printf("|    Vagonetas    |        %d       |\n", clasificacion3.numElementos());
        System.out.printf("|    Camiones     |        %d       |\n", clasificacion4.numElementos());
        System.out.printf("|    Autobuses    |        %d       |\n", clasificacion5.numElementos());
        System.out.println("------------------------------------");
        enter();
    }

    public static void vehiculosRetirados() {
        clear();
        nombreClasificacion.imprimirVehiculosClasificacion();
        System.out.println(" ");
        enter();
    }

    public static void salir() {
        System.exit(0);
    }

    public static Pila obtenerPila(int clasificacion) {
        switch (clasificacion) {
            case 1: return clasificacion1;
            case 2: return clasificacion2;
            case 3: return clasificacion3;
            case 4: return clasificacion4;
            case 5: return clasificacion5;
            default:
                return null;
        }
    }

    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }//clear

    public static void enter(){
        Scanner continuar = new Scanner(System.in);
        continuar.useDelimiter("\n");
        System.out.print("Presione Enter para continuar");
        continuar.next();
    }//enter

}
