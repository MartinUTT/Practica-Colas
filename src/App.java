import java.util.Scanner;
import Lista.*;

public class App {
    static Scanner read = new Scanner(System.in);
    static Pila clasificacion1 = new Pila();
    static Pila clasificacion2 = new Pila();
    static Pila clasificacion3 = new Pila();
    static Pila clasificacion4 = new Pila();
    static int autosRetirados = 0;

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    ingresarAuto();
                    break;
                case 2:
                    retirarAuto();
                    break;
                case 3:
                    autosPorClasificacion();
                    break;
                case 4:
                    autosTotales();
                    break;
                case 5:
                    autosRetirados();
                    break;
                case 6:
                    salir();
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 6);
        read.close();
    }

    public static int menu() {
        System.out.println("\nMenú:");
        System.out.println("1. Ingresar auto");
        System.out.println("2. Retirar auto");
        System.out.println("3. Autos por clasificación");
        System.out.println("4. Autos totales");
        System.out.println("5. Autos retirados");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = read.nextInt();
        read.nextLine(); // Limpiar el buffer de entrada
        return opcion;
    }

    public static void ingresarAuto() {
        System.out.println("\nIngresar auto:");
        System.out.print("Ingrese la clasificación del vehículo (1-4): ");
        int clasificacion = read.nextInt();
        read.nextLine(); // Limpiar el buffer de entrada
        Pila pilaClasificacion = obtenerPila(clasificacion);
        if (pilaClasificacion == null) {
            System.out.println("Clasificación inválida.");
            return;
        }
        if (pilaClasificacion.pilaLlena()) {
            System.out.println("No hay espacio disponible en esta clasificación.");
            return;
        }
        System.out.print("Ingrese el nombre del vehículo: ");
        String nombre = read.nextLine();
        pilaClasificacion.agregar(Integer.toString(clasificacion), nombre);
        System.out.println("Vehículo agregado a la clasificación " + clasificacion + ". Número en la pila: " + pilaClasificacion.numElementos());
        if (pilaClasificacion.pilaLlena()) {
            System.out.println("La clasificación " + clasificacion + " está llena.");
            autosTotales();
        }
    }

    public static void retirarAuto() {
        System.out.println("\nRetirar auto:");
        System.out.print("Ingrese la clasificación del vehículo (1-4): ");
        int clasificacion = read.nextInt();
        read.nextLine(); // Limpiar el buffer de entrada
        Pila pilaClasificacion = obtenerPila(clasificacion);
        if (pilaClasificacion == null) {
            System.out.println("Clasificación inválida.");
            return;
        }
        if (pilaClasificacion.pilaVacia()) {
            System.out.println("No hay autos en esta clasificación.");
            return;
        }
        pilaClasificacion.retirar();
        autosRetirados++;
        System.out.println("Vehículo retirado de la clasificación " + clasificacion);
    }

    public static void autosPorClasificacion() {
        System.out.println("\nAutos por clasificación:");
        System.out.print("Ingrese la clasificación del vehículo (1-4): ");
        int clasificacion = read.nextInt();
        read.nextLine(); // Limpiar el buffer de entrada
        Pila pilaClasificacion = obtenerPila(clasificacion);
        if (pilaClasificacion == null) {
            System.out.println("Clasificación inválida.");
            return;
        }
        System.out.println("Autos en la clasificación " + clasificacion + ":");
        pilaClasificacion.imprimir();
    }

    public static void autosTotales() {
        System.out.println("\nAutos totales por clasificación:");
        System.out.println("Clasificación 1: " + clasificacion1.numElementos() + " autos");
        System.out.println("Clasificación 2: " + clasificacion2.numElementos() + " autos");
        System.out.println("Clasificación 3: " + clasificacion3.numElementos() + " autos");
        System.out.println("Clasificación 4: " + clasificacion4.numElementos() + " autos");
    }

    public static void autosRetirados() {
        System.out.println("\nTotal de autos retirados: " + autosRetirados);
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
            default:
                return null;
        }
    }
}
