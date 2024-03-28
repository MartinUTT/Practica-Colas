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
    static int vehiculosRetirados = 0;
    static int clasificacion;
    static String descripcion, codigo;
    static Pila pilaClasificacion;
    static char repetir;

    public static void main(String[] args) {
        readString.useDelimiter("\n");
        int opcion;
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
            System.out.println("Fundición de vehículos");
            System.out.println("1. Ingresar vehículo");
            System.out.println("2. Retirar vehículo");
            System.out.println("3. Vehículos por clasificación");
            System.out.println("4. Vehículos totales");
            System.out.println("5. Vehículos retirados");
            System.out.println("6. Salir");

            try { 
                System.out.print("Opción: ");
                respMenu = read.nextInt();
            } catch (Exception e) {
                System.out.println("\nIngrese una opción válida");
                error = true;
                read.nextLine();
            }
        } while (respMenu < 1 || respMenu > 6 || error);
        return respMenu;
    }//menuProductos

    public static void ingresarVehiculo() {
        clear();
        System.out.println("\n\t\tIngresar Vehículo");
        do {
            System.out.print("Ingrese la clasificación del vehículo (1-5): ");
            clasificacion = read.nextInt();
        } while (clasificacion>5 || clasificacion<1);

        pilaClasificacion = obtenerPila(clasificacion);
        if (pilaClasificacion.pilaLlena()) {
            System.out.println("No hay espacio disponible en esta clasificación.");
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
            System.out.print("Ingrese la clasificación del vehículo (1-5): ");
            clasificacion = read.nextInt();
        } while (clasificacion>5 || clasificacion<1);
        pilaClasificacion = obtenerPila(clasificacion);
        if (pilaClasificacion.pilaVacia()) {
            System.out.println("No hay vehículos en esta clasificación.");
            enter();
        }else{
            pilaClasificacion.retirar();
            vehiculosRetirados++;
            System.out.println("Vehículo retirado de la clasificación " + clasificacion);
            do {
                System.out.print("\nDesea retirar otro vehículo: S/N ");
                repetir = read.next().toUpperCase().charAt(0);
            } while (repetir != 'S' && repetir != 'N');
            if (repetir == 'S') {
                retirarVehiculo();
            } 
        }
    }

    public static void vehiculosPorClasificacion() {
        System.out.println("\n\t\tVehículos por clasificación:");
        do {
            System.out.print("Ingrese la clasificación del vehículo (1-5): ");
            clasificacion = read.nextInt();
        } while (clasificacion>5 || clasificacion<1);
        pilaClasificacion = obtenerPila(clasificacion);
        if (pilaClasificacion == null) {
            System.out.println("Clasificación inválida.");
            enter();
        }else{
            System.out.println("Vehículos en la clasificación " + clasificacion + ":");
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
        System.out.println("\n\t\tVehículos totales por clasificación:");
        System.out.println("Clasificación 1: " + clasificacion1.numElementos() + " vehículos");
        System.out.println("Clasificación 2: " + clasificacion2.numElementos() + " vehículos");
        System.out.println("Clasificación 3: " + clasificacion3.numElementos() + " vehículos");
        System.out.println("Clasificación 4: " + clasificacion4.numElementos() + " vehículos");
        System.out.println("Clasificación 5: " + clasificacion4.numElementos() + " vehículos");
        enter();
    }

    public static void vehiculosRetirados() {
        System.out.println("\nTotal de vehículos retirados: " + vehiculosRetirados);
    }

    public static void salir() {
        System.out.println("\n¡Hasta luego!");
    }

    public static Pila obtenerPila(int clasificacion) {
        switch (clasificacion) {
            case 1: 
                return clasificacion1;
            case 2:
                return clasificacion2;
            case 3:
                return clasificacion3;
            case 4:
                return clasificacion4;
            case 5:
                return clasificacion5;
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
