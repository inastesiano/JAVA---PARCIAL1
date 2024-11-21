import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        gestionNotas gestion = new gestionNotas();
        String[][] alumnos = gestion.getAlumnos();
        String[][] materias = gestion.materias;
        String[][] notasFinales = gestion.notasFinales;

        //INICIALIZAMOS MATERIAS
        materias[0][0] = "Ciencias";
        materias[1][0] = "Historia";
        materias[2][0] = "Geografia";
        materias[3][0] = "Matematicas";
        materias[4][0] = "Fisica";

        //INICIALIZAMOS NOTAS FINALES
        notasFinales[0][0] = "Rodolfo Fernandez";
        notasFinales[1][0] = "Luis Gomez";
        notasFinales[2][0] = "Andrea Pereira";
        notasFinales[3][0] = "Juan Cruz Gonzales";




        for (int alu = 0; alu < 4; alu++) {
            System.out.println("-------------------- ALUMNO: " + alumnos[alu][1] + " --------------------");
            gestion.ingresarNotas();
            gestion.mostrarNotas(alu, alumnos);
            gestion.materiaMasAlta();
            gestion.promedioNotasFinales(alu);
        }


        gestion.mostrarNotasFinales();
        gestion.mejorPromedio();





    }
}