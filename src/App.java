import java.util.Scanner;

public class App {
    static String nombreEstudiante = "N/A";
    static Double nota1;
    static Double nota2;
    static Double nota3;

    static Double promedio;

    public static void main(String[] args) {
        int controlMenu = 0;
        Scanner entrada = new Scanner(System.in);
        do {
            mostrarMenu();

            controlMenu = entrada.nextInt();
            entrada.nextLine();
            switch (controlMenu) {
                case 1:
                    registrarEstudiante(entrada);
                    break;
                case 2:
                    mostrarInfoEstudiante();
                    break;
                case 3:
                    // Validamos que ya esté registrado el estudiante
                    System.out.println("-- Promedio del estudiante --");
                    if (nombreEstudiante.equals("N/A")) {
                        System.out.println("No has registrado un usuario!!!!\n");
                    } else {
                        promedio = calcularPromedio();
                        System.out.printf("El promedio del estudiante %s es: %.2f %n", nombreEstudiante, promedio);
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                default:
                    // Para que no se muestre el mensaje "Opción inválida" cuando salgas, se valida
                    // que control menú sea distinto de cero
                    if (controlMenu != 0) {
                        System.out.println("Opción Inválida");
                    }

            }
        } while (controlMenu != 0);

        entrada.close();
    }

    // Método para registrar el estudiante
    public static void registrarEstudiante(Scanner entrada) {
        // Variable para validar que tanto el nombre como las notas sean correctas
        Boolean isValid = true;
        System.out.println("\n-- Registro --");

        // Bloque de código para recibir el nombre por consola
        // Hasta que el nombre no sea válido no parará el bucle
        do {

            System.out.print("Ingresa el nombre del estudiante: ");
            nombreEstudiante = entrada.nextLine();
            isValid = validarNombre(nombreEstudiante);
        } while (isValid == false);

        System.out.println("Ingresa las 3 notas");

        // Hasta que la nota no sea válida no parará el bucle y no seguirá con el
        // código en cada nota

        do {
            System.out.print("Nota 1: ");
            nota1 = entrada.nextDouble();
            isValid = validarNotas(nota1);

        } while (isValid == false);
        do {
            System.out.print("Nota 2: ");
            nota2 = entrada.nextDouble();
            isValid = validarNotas(nota2);

        } while (isValid == false);

        do {
            System.out.print("Nota 3: ");
            nota3 = entrada.nextDouble();
            isValid = validarNotas(nota3);

        } while (isValid == false);

        System.out.println("Hecho... \n");
    }

    // Método para mostrar la información del estudiante
    public static void mostrarInfoEstudiante() {
        System.out.println("\n -- Info de Estudiante --");
        if (nombreEstudiante.equals("N/A")) {
            System.out.println("Todavía no registras un estudiante!!!\n");

        } else {
            System.out.printf(
                    "Las notas del estudiante %s son:\n Primer nota:%.2f \n Segunda nota: %.2f \n Tercera nota: %.2f \n",
                    nombreEstudiante,
                    nota1,
                    nota2,
                    nota3);
        }

    }

    /* */
    // Métoddo que por medio de una variable booleana se valida que se esté pasando
    // el
    // formato de nota correcta
    public static Boolean validarNotas(Double nota) {

        // Valida tres casos:
        // si la nota nota es nula
        // Si la nota es menor a cero
        // Si la nota es mayor a la nota máxima(en este caso 5)
        // Si se cumple uno de estos casos no será válida la nota
        if (nota == null || nota < 0 || nota > 5) {
            System.out.println("Nota inválida");
            return false;
            // De lo contrario, significará que la nota es válida
            // Entonces el método devolverá el vlor true
        } else
            return true;

    }

    // Validar el nombre
    public static Boolean validarNombre(String nombre) {

        // Valida dos casos:
        // si el nombre es nulo
        // si el nombre es un string vacío
        // Si se cumple uno de estos casos no será válido el nombre
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Nombre inválido");
            return false;
            // De lo contrario, significará que el nombre es válido
            // Entonces el método devolverá el vlor true
        } else
            return true;
    }

    // Método para calcular el promedio
    public static Double calcularPromedio() {
        return (nota1 + nota2 + nota3) / 3;
    }

    // Método para mostrar el menú
    public static void mostrarMenu() {
        System.out.println("--- Sistema de Registro de Estudiantes ---\n");
        System.out.println("1. Registrar datos de un estudiante");
        System.out.println("2. Mostrar datos del estudiante actual");
        System.out.println("3. Calcular promedio de notas del estudiante actual");
        System.out.println("0. Salir");
        System.out.println("Ingrese su opción: ");
    }
}
