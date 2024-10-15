import java.util.Scanner;

public class GeneraPC {

    static String[][] componentesPC = {
            {"AAA","Placa Madre", "20000", "S"} ,
            {"BBB","Procesador" , "25000" , "S"} ,
            {"CCC","Memoria RAM", "5000" , "S"} ,
            {"DDD","Placa de Red", "3000" , "N"} ,
            {"EEE","Disco Rigido SSD", "22000" , "S"} ,
            {"FFF"," Placa de Video", "42000" , "N"} ,
            {"GGG", "Monitor Led 21", "32000" , "N"} ,
            {"HHH","Monitor Led 25", "41000" , "N"} ,
            {"JJJ","Kit Teclado - Mouse", "9000" , "N"},
            {"KKK","Gabinete", "6500" , "S"},
            {"LLL","Fuente Alimentación", "6500" , "S"},
            {"MMM","Placa de Sonido", "16500" , "N"}
    };

    public static void main(String[] args) {
        Computadora computadora = new Computadora();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese marca: ");
        computadora.setMarca(teclado.nextLine());

        System.out.println("Ingrese modelo: ");
        computadora.setModelo(teclado.nextLine());

        while (computadora.getCodigoBarras() < 7 || computadora.getCodigoBarras() > 15){
            System.out.println("Ingrese codigo de barras: ");
            computadora.setCodigoBarras(teclado.nextLong());
        }


        System.out.println(computadora.getCodigoBarras());


//        computadora.setCodigoBarras(teclado.nextLong());
//        validarCodigoBarras();

    }

//    public static String validarCodigoBarras () {
//        Scanner teclado = new Scanner(System.in);
//        System.out.println("Ingrese codigo de barras: ");
//        String codigoBarras = teclado.nextLine();
//        if (codigoBarras.length() < 7 || codigoBarras.length() > 15) {
//            validarCodigoBarras();
//        }
//        return codigoBarras;
//    }
}