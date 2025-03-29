package prácticos.arreglos.unidimensionales.bidimensionales;

import java.util.Scanner;

public class PrácticosArreglosUnidimensionalesBidimensionales {

    public static Scanner teclado = new Scanner(System.in);
    public static String[][] calificacionEstudiante;

    public static void main(String[] args) {
        boolean salir = false;
        while (true) {
            System.out.println("***SISTEMA DE CALIFICACIONES***");
            System.out.println("1. Agregar Estudiantes");
            System.out.println("2. Mosrar lista de estudiantes");
            System.out.println("3. Mostrar promedios Estudinates");
            System.out.println("4. Salir");
            System.out.println("Seleccione una opcion:");
            int opc;
            while (true) {
                try {
                    opc = teclado.nextInt();
                    teclado.nextLine(); // Limpiar buffer
                    break;
                } catch (Exception e) {
                    System.out.println("Error " + e.getMessage());
                    teclado.nextLine(); // Limpiamos el buffer
                    System.out.println("Seleccione una opcion Correcta:");
                }
            }

            switch (opc) {
                case 1:
                    almacenarNota();
                    break;
                case 2:
                    MostrarEstudiantes();
                    break;
                case 3:
                    CalcularPromedio();
                    break;
                case 4:
                    System.out.println("Adiosss....");
                    salir = true;
                    return;
                default:
                    System.out.println("Seleccione una opcion correcta");
                    break;
            }
        }

    }

    public static void almacenarNota() {
        int cantidadEstudiantes;
        while (true) {
            try {
                System.out.println("Digite la cantidad de estudiantes");
                cantidadEstudiantes = teclado.nextInt();
                teclado.nextLine();
                if (cantidadEstudiantes > 0) {
                    break;
                } else {
                    System.out.println("ERROR: Ingrese un numero mayor que 0.");
                }

            } catch (Exception e) {
                System.out.println("ERROR: FORMATO INCORRECTO " + e.getMessage());
                teclado.nextLine();
            }
        }
        calificacionEstudiante = new String[cantidadEstudiantes][3];
        for (int i = 0; i < calificacionEstudiante.length; i++) {
            String nombreEstudiante;
            while (true) {
                System.out.println("Digite el nombre del estudiante numero " + (i + 1));
                nombreEstudiante = teclado.nextLine();
                if (nombreEstudiante.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    break;
                } else {
                    System.out.println("ERROR: Solo se permiten letras y espacios.");
                }
            }
            calificacionEstudiante[i][0] = nombreEstudiante;
            String nombreMateria;
            while (true) {
                System.out.println("Digite el nombre de la materia ");
                nombreMateria = teclado.next();
                if (nombreMateria.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    break;
                } else {
                    System.out.println("ERROR: Solo se permiten letras y espacios.");
                }
            }
            calificacionEstudiante[i][1] = nombreMateria;
            float nota;
            while (true) {
                try {
                    while (true) {
                        try {
                            System.out.println("Digite la calificacion de la materia dentro del rango de 1 a 5: " + nombreMateria);
                            nota = teclado.nextFloat();
                            teclado.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Error:" + e.getMessage());
                            teclado.nextLine();
                        }
                    }
                    if (nota >= 0 && nota <= 5) {
                        break;
                    } else {
                        System.out.println("ERROR: Solo se permiten numero positivos y el rango de califiaciones es de 1 a 5 ");
                    }
                } catch (Exception e) {
                    System.out.println("ERROR formato incorrecto " + e.getMessage());
                    teclado.nextLine();
                }
            }
            calificacionEstudiante[i][2] = String.valueOf(nota);
        }
    }

    public static void MostrarEstudiantes() {
        if (calificacionEstudiante == null || calificacionEstudiante.length == 0) {
            System.out.println("No existen estudiantes EXISTENTES en el sistema");
            return;
        }
        System.out.println("Lista de estudinates en el sistema: \n");
        for (int i = 0; i < calificacionEstudiante.length; i++) {
            System.out.println("ID_Estudiante: " + (i + 1) + "\n"
                    + "Nombre: " + calificacionEstudiante[i][0] + "\n"
                    + "Materia: " + calificacionEstudiante[i][1] + "\n"
                    + "Calificacion: " + calificacionEstudiante[i][2]);
            System.out.println("------------------------------");
            System.out.println();
        }
    }

    public static void CalcularPromedio() {
        if (calificacionEstudiante == null || calificacionEstudiante.length == 0) {
            System.out.println("No existen estudiantes EXISTENTES en el sistema");
            return;
        }

        String estudianteMayor = "";
        String estudianteMenor = "";
        float mayor = Float.MIN_VALUE; // Inicia con el menor valor posible
        float menor = Float.MAX_VALUE; // Inicia con el mayor valor posible
        float SumaTotal = 0;
        float nota = 0;
        double Promedio;
        int cantidadEstudiantes = calificacionEstudiante.length;
        System.out.println("Lista de Promedios de los estudinates: \n");
        for (int i = 0; i < calificacionEstudiante.length; i++) {
            SumaTotal += Float.parseFloat(calificacionEstudiante[i][2]);
            nota = Float.parseFloat(calificacionEstudiante[i][2]);
            if (nota > mayor) {
                mayor = nota;
                estudianteMayor = calificacionEstudiante[i][0];
                System.out.println("La calificacion mas alta es de: " + estudianteMayor + " con " + mayor);
            } else if (nota < menor) {
                menor = nota;
                estudianteMenor = calificacionEstudiante[i][0];
                System.out.println("La calificacion mas baja es de: " + estudianteMenor + " con " + menor);
            } else {
                System.out.println("");
            }
        }
        Promedio = SumaTotal / cantidadEstudiantes;
        System.out.println("------------------------------");
        System.out.println("La suma total de las calificaciones es: " + SumaTotal);
        System.out.println("------------------------------");
        System.out.println("El promedio de los estudinates es de: " + Promedio);
        System.out.println("------------------------------");
    }

}
