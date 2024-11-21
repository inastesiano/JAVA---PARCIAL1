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
        System.out.println("");

        int matrizColindante[] = obtenerValoresCentrales(matriz, dimension);
        System.out.println("El promedio TOTAL entre ambas matrices es de: " + calcularPromedioDeMatrices(matriz, matrizColindante));

        boolean salir = false;
        while (salir == false){
            System.out.println("DESEA INICIAR NUEVAMENTE EL PROGRAMA? (y/n): ");
            String rta = teclado.nextLine().toLowerCase();
            if (rta.equals("y")){
                pedirDimension();
            }else if (rta.equals("n")){
                System.out.println("Saliendo del programa...");
                break;
            }else {
                System.out.println("Ingrese un caracter válido!");
            }
        }
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
        System.out.println("");
        return matrizColindante;
    }


    public static void numCorrecto(int dimension){
        if((dimension <3 || dimension >15) || (dimension %2) == 0 ){
            pedirDimension();
        }
    }

    public static double calcularPromedioDeMatrices (int[][] matriz, int[] matrizValoresCentral){
        double suma1 =0, suma2 =0, promedio1 = 0, promedio2 = 0;

        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz.length; j++) {
                suma1 += matriz[i][j];
            }
        }

        for (int i = 0; i < matrizValoresCentral.length ; i++) {
            suma2 += matrizValoresCentral[i];
        }

        promedio1 = suma1/(matriz.length*matriz.length);
        promedio2 = suma2/(matrizValoresCentral.length);

        System.out.println("La suma de la matriz 1 es: " + suma1);
        System.out.println("El promedio de la matriz 1 es: " + promedio1);

        System.out.println("La suma de la matriz 2 es: " + suma2);
        System.out.println("El promedio de la matriz 2 es: " + promedio2);
        System.out.println("");

        return (promedio1 + promedio2) / 2;
    }




}

