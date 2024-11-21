import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        while (true) {
            int dimension = 0;
            while ((dimension % 2) == 0 || dimension < 3 || dimension > 15) {
                System.out.println("Ingrese dimension de matriz: ");
                dimension = sc.nextInt();
            }

            int[][] matriz = new int[dimension][dimension];

            //LLENAR ULTIMA FILA MANUALMENTE
            for (int i = 0; i < dimension; i++) {
                int valor = 0;
                while (valor == 0 || valor < 10 || valor > 99) {
                    System.out.println("Ingrese valor " + i + " (No nulo entre 10 y 9): ");
                    valor = sc.nextInt();
                    matriz[dimension - 1][i] = valor;
                }
            }

            //LLENAR MATRIZ RANDOM 10-99
            for (int i = 0; i < dimension - 1; i++) {
                for (int j = 0; j < dimension; j++) {
                    matriz[i][j] = rd.nextInt(10, 99);
                }
            }

            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    System.out.print("[" + matriz[i][j] + "]");
                }
                System.out.println("");
            }

            int[] colindante = new int[9];
            colindante = obtenerValoresCentrales(matriz, dimension);

            System.out.println("------- Matriz colindante -------");
            for (int i = 0; i < 9; i++) {
                System.out.print("[" + colindante[i] + "]");
            }
            System.out.println("");

            ordenarMatriz(colindante);
            calcularPromedioDeMatrices(matriz, colindante);

            String rta = "";
            sc.nextLine(); //limpiar buffer
            System.out.print("Desea salir del programa? (y/n): ");
            rta = sc.nextLine();
            if (rta.equalsIgnoreCase("y")){
                break;
            }
        }
    }

    public static int[] obtenerValoresCentrales(int[][] matriz, int dimension){
        int[] colindante = new int[9];
        int indexCentral = (dimension-1)/2;

        colindante[0] = matriz[indexCentral][indexCentral];
        colindante[1] = matriz[indexCentral-1][indexCentral];;
        colindante[2] = matriz[indexCentral-1][indexCentral-1];;
        colindante[3] = matriz[indexCentral-1][indexCentral+1];;
        colindante[4] = matriz[indexCentral][indexCentral-1];;
        colindante[5] = matriz[indexCentral][indexCentral+1];;
        colindante[6] = matriz[indexCentral+1][indexCentral-1];;
        colindante[7] = matriz[indexCentral+1][indexCentral+1];;
        colindante[8] = matriz[indexCentral+1][indexCentral];;

        return colindante;
    }

    public static void ordenarMatriz(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("------- Matriz ordenada -------");
        for (int num : arr) {
            System.out.print("[" + num + "]");
        }
        System.out.println("");
    }


    public static void calcularPromedioDeMatrices (int[][] matriz, int[] colindante){

        System.out.println("");
        int suma = 0, nElementos = 0;
        double promedio = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                suma += matriz[i][j];
                nElementos++;
            }
        }

        promedio = suma/(matriz.length^2);
        System.out.println("Suma total matriz cuadrada: " + suma);
        System.out.println("Cantidad de elementos: " + nElementos);
        System.out.println("Promedio de matriz cuadrada: " + promedio);

        int sumaCol = 0, nElementosCol = 0;
        double promedioCol = 0;
        for (int i = 0; i < 9; i++) {
            sumaCol += colindante[i];
            nElementosCol++;
        }

        promedioCol = sumaCol/9;
        System.out.println("Suma total matriz colindante: " + sumaCol);
        System.out.println("Cantidad de elementos: " + nElementosCol);
        System.out.println("Promedio de matriz colindante: " + promedioCol);

        double promedioTotal = 0;
        promedioTotal = (promedioCol+promedio)/2;

        System.out.println("Promedio total -> " + promedioTotal);
    }
}