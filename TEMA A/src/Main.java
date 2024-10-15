import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        pedirDimension();
    }


    public static void pedirDimension(){
        System.out.println("Ingrese el orden de la matriz CUADRADA (Numero impar entre 3 y 15)");
        Scanner teclado = new Scanner(System.in);
        int dimension = teclado.nextInt();
        numCorrecto(dimension);
        int matriz[][] = new int[dimension][dimension];


        //PEDIMOS LOS NUMEROS AL USUARIO PARA COMPLETAR LA ULTIMA FILA
        for(int i=0; i<dimension; i++){
            int num = 0;
            while (num == 0 || num<10 || num>99){
                System.out.println("Ingrese numero entre 10 y 99 no nulo -> [COLUMNA " + (i+1) + "]");
                num = teclado.nextInt();
                if (num == 0 || num<10 || num>99){
                    System.out.println("Ingrese un número válido...");
                }
            }
            matriz[dimension-1][i] = num;
        }

        Random rd = new Random();


        //LLENA DE ELEMENTOS RANDOM EXCEPTO LA ULTIMA FILA
        for (int i=0; i<(dimension-1); i++){
            for (int j = 0; j <(dimension); j++){
                matriz[i][j]= rd.nextInt(10, 99);
            }
        }

        //IMPRIME MATRIZ
        for (int i=0; i<dimension; i++){
            for (int j = 0; j <dimension; j++){
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println("");
        }

        obtenerValoresCentrales(matriz, dimension);
    }

    public static int[] obtenerValoresCentrales(int matriz[][], int dimension){
        int matrizColindante[] = new int [9];
        int indexCentral = (dimension-1)/2;
        int valorCentral = matriz [indexCentral][indexCentral];
        matrizColindante[8] = valorCentral;

        //OBTENGO VALORES COLINDANTES
        int arriba = matriz[indexCentral-1][indexCentral];
        int abajo = matriz[indexCentral+1][indexCentral];
        int izquierda = matriz[indexCentral][indexCentral-1];
        int derecha = matriz[indexCentral][indexCentral+1];
        int supIzq = matriz[indexCentral-1][indexCentral-1];
        int supDer = matriz[indexCentral-1][indexCentral+1];
        int infIzq = matriz[indexCentral+1][indexCentral-1];
        int infDer = matriz[indexCentral+1][indexCentral+1];

        System.out.println("MATRIZ COLINDANTE: ");

        //LOS ASIGNO A MATRIZ COLINDANTE
        matrizColindante[0] = arriba;
        matrizColindante[1] = abajo;
        matrizColindante[2] = izquierda;
        matrizColindante[3] = derecha;
        matrizColindante[4] = supIzq;
        matrizColindante[5] = supDer;
        matrizColindante[6] = infIzq;
        matrizColindante[7] = infDer;

        //IMPRIMO MATRIZ COLINDANTE
        for (int i=0; i<9; i++){
            System.out.print("[" + matrizColindante[i] + "]");
        }
        return matrizColindante;
    }

    public static void numCorrecto(int dimension){
        if((dimension <3 || dimension >15) || (dimension %2) == 0 ){
            pedirDimension();
        }
    }


}

