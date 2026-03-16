
package batallanaval;

import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int filas = 0, columnas = 0;

        try {
            // Solicitar dimensiones de la matriz
            System.out.print("Ingrese el número de filas: ");
            filas = sc.nextInt();
            System.out.print("Ingrese el número de columnas: ");
            columnas = sc.nextInt();

            // Validar dimensiones
            if (filas <= 0 || columnas <= 0) {
                System.out.println("Error: Las dimensiones deben ser mayores que cero.");
                return;
            }

            // Crear la matriz
            int[][] matriz = new int[filas][columnas];

            // Llenar la matriz con datos ingresados por el usuario
            System.out.println("Ingrese los elementos de la matriz:");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.printf("Elemento [%d][%d]: ", i, j);
                    matriz[i][j] = sc.nextInt();
                }
            }

            // Mostrar la matriz
            System.out.println("\nMatriz ingresada:");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print(matriz[i][j] + "\t");
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Debe ingresar números enteros.");
        } finally {
            sc.close();
        }
    }
}
