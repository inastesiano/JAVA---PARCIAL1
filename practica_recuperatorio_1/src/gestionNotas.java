import java.util.Scanner;

public class gestionNotas {

    //ARRAY DE ALUMNOS
    private String[][] alumnos = {
            {"60902", "Rodolfo Fernandez"},
            {"61654", "Luis Gomez"},
            {"61852", "Andrea Pereira"},
            {"61754", "Juan Cruz Gonzales"}
    };

    public String[][] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(String[][] alumnos) {
        this.alumnos = alumnos;
    }

    public void mostrarAlumnos(){
        for (int alu = 0; alu < 4; alu++) {
            System.out.print("Legajo: " + alumnos[alu][0] + ", Alumno: " + alumnos[alu][1]);
            System.out.println("");
        }
    }


    //ARRAY DE MATERIAS
    String[][] materias = new String[5][4];

    public void ingresarNotas(){

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            for (int j = 1; j < 3; j++) {
                materias[i][j] = "0"; //inicializo en cero para que no de errores el parseo
                while (Double.parseDouble(materias[i][j]) <= 0 || Double.parseDouble(materias[i][j]) > 10) {
                    System.out.print("MATERIA: " + materias[i][0] + " - CALIFICACION " + (j) + ": ");
                    materias[i][j] = sc.nextLine();
                }
            }
            double sumatoria = 0;
            for (int j = 1; j < 3; j++) {
                sumatoria += Double.parseDouble(materias[i][j]);
            }
            materias[i][3] = String.valueOf(sumatoria / 2);
            System.out.println("---- Promedio de " + materias[i][0] + " = " + materias[i][3] + " ----\n");
        }
    }


    public void mostrarNotas(int alu, String[][] alumnos){
        System.out.println("-------------------- TABLA DE NOTAS (" + alumnos[alu][1]+ ") --------------------");
        System.out.println("|Materia| \t\t|Nota 1| \t\t|Nota 2| \t\t|Nota final|");
        for (int i = 0; i < 5; i++) {
            System.out.println(materias[i][0] +	"\t\t" + materias[i][1] +	"\t\t\t" + materias[i][2] +	"\t\t\t" + materias[i][3]);
        }
        System.out.println("");
    }

    public void materiaMasAlta(){
        String materia = "";
        double mayor = 0;
        for (int i = 0; i < 5; i++) {
            if (Double.parseDouble(materias[i][3])>mayor){
                mayor =+ Double.parseDouble(materias[i][3]);
                materia = materias[i][0];
            }
        }

        System.out.println("---- Materia con calificacion más alta -> " + materia + " (" + mayor + ")");
        System.out.println("");

    }

    //ARRAY DE NOTAS FINALES
    String[][] notasFinales = new String[4][2];

    public void promedioNotasFinales (int alu){

        //SUMA DE NOTA FINAL DE CADA MATERIA
        double suma = 0, promedio = 0;
        for (int i = 0; i < 5; i++) {
            suma += Double.parseDouble(materias[i][3]);
        }
        promedio = suma/5;


        notasFinales[alu][1] = String.valueOf(promedio);

    }

    public void mostrarNotasFinales(){
        System.out.println("-------------------- TABLA DE NOTAS FINALES --------------------");
        System.out.println("|ALUMNO|        \t\t|NOTA FINAL|");
        for (int i = 0; i < 4; i++) {
            System.out.println(notasFinales[i][0] + "\t\t" + notasFinales[i][1]);
        }
    }

    public void mejorPromedio(){
        double mejor = 0;
        String nombre = "";
        for (int i = 0; i < 4; i++) {
            if(Double.parseDouble(notasFinales[i][1])>mejor){
                mejor =+ Double.parseDouble(notasFinales[i][1]);
                nombre = notasFinales[i][0];
            }
        }
        System.out.println("El alumno con el mejor promedio es: " + nombre + " (" + mejor + ")" );
    }

}

