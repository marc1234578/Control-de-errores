/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control.de.errores;

/**
 *
 * @author marcos
 */
import java.util.Scanner;
public class ControlDeErrores {
    static int stock = 0;
    static final Scanner scanner = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> {
                    boolean repetir = true;
                    while (repetir) {
                        int ingreso = leerEntero("Cantidad a ingresar: ");
                        if (ingreso > 0) {
                            stock += ingreso;
                            System.out.println("✅ Stock actualizado: " + stock + " computadoras.");
                        } else {
                            System.out.println("⚠️ La cantidad debe ser mayor a 0.");
                        }
                        repetir = subMenuAccion();
                    }
                }
                case 2 -> {
                    boolean repetir = true;
                    while (repetir) {
                        int salida = leerEntero("Cantidad a retirar: ");
                        if (salida <= 0) {
                            System.out.println("⚠️ La cantidad debe ser mayor a 0.");
                        } else if (stock - salida <= 0) {
                            System.out.println("🚫 Error: No puedes dejar el stock en cero o negativo.");
                        } else {
                            stock -= salida;
                            System.out.println("✅ Stock actualizado: " + stock + " computadoras.");
                        }
                        repetir = subMenuAccion();
                    }
                }
                case 3 -> {
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                }
                default -> {
                    System.out.println("❌ Opción inválida.");
                    pausar();
                }
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("\n=== GESTIÓN DE INVENTARIO ===");
        System.out.println("Stock actual: " + stock + " computadoras");
        System.out.println("1. Ingresar computadoras al stock");
        System.out.println("2. Retirar computadoras del stock");
        System.out.println("3. Salir");
    }

    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida. Ingrese un número entero.");
            }
        }
    }

    public static boolean subMenuAccion() {
        System.out.println("\n1. Realizar otra operación");
        System.out.println("2. Volver al menú principal");
        int opcion = leerEntero("Seleccione una opción: ");
        return opcion == 1;
    }

    public static void pausar() {
        System.out.print("Presione cualquier tecla y luego Enter para volver al menú... ");
        scanner.next();
    }

    static class StockInsuficienteException extends RuntimeException {
        public StockInsuficienteException(String mensaje) {
            super(mensaje);
        }
    }
    public static void mostrarFormularioRegistro() {
    System.out.println("Formulario de Registro: Nombre, Email, Password");
    }
}