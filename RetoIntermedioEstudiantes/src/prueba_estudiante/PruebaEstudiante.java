package prueba_estudiante;

// Importaciones de la clase Estudiante y de ArrayList.
import estudiante.Estudiante;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PruebaEstudiante {
    public static void main(String[] args) {
        // Declaración de Scanner.
        Scanner sc = new Scanner(System.in);
        // Declaración de ArrayList de tipo Estudiante.
        ArrayList<Estudiante> estudianteA = new ArrayList<>();

        // Realizar un menú.
        int opcion;
        boolean salir = false;
        while(!salir){
            System.out.println("1. Ingresar estudiantes.");
            System.out.println("2. Lista completa de estudiantes.");
            System.out.println("3. Estudiantes aprobados y reprobados.");
            System.out.println("4. Promedio general del grupo.");
            System.out.println("5. Estudiante con mejor promedio.");
            System.out.println("6. Guardar archivo de texto de estudiantes.");
            System.out.println("7. Salir.");

            // Opciones para digitar.
            System.out.print("Digite una opción entre 1 y 5: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion){
                case 1:
                    System.out.println("1. Ingresar estudiantes.");
                    // Declaración de variables.
                    int cantidadE;
                    System.out.print("Digite la cantidad de estudiantes que desea ingresar: ");
                    cantidadE = Integer.parseInt(sc.nextLine());
                    // Recorre la cantidad de estudiantes a ingresar.
                    for (int i = 1; i <= cantidadE; i++){
                        Estudiante est = new Estudiante();

                        // Pongo los atributos de cada estudiante.
                        System.out.print("Digite su identificación: ");
                        est.setIdEst(Integer.parseInt(sc.nextLine()));
                        System.out.print("Digite su nombre: ");
                        est.setNombreEst(sc.nextLine());
                        System.out.print("Digite su edad: ");
                        est.setEdadEst(Integer.parseInt(sc.nextLine()));
                        System.out.print("Digite su promedio: ");
                        est.setPromedioEst(Double.parseDouble(sc.nextLine()));
                        System.out.println("Registro exitoso. \n");

                        estudianteA.add(est);
                    }
                    System.out.println("Se guardaron: " + estudianteA.size() + " estudiantes");
                    break;
                case 2:
                    Iterator<Estudiante> itrEst = estudianteA.iterator();
                    System.out.println("Actualmente tenemos registrados " + estudianteA.size() + " estudiantes");
                    while(itrEst.hasNext()){
                        Estudiante objEst = itrEst.next();
                        System.out.println("Estos son los datos de los estudiantes: " + "Identificación: " + objEst.getIdEst() +
                                ", Nombre: " + objEst.getNombreEst() +
                                ", Edad: " + objEst.getEdadEst() +
                                ", Promedio: " + objEst.getPromedioEst());
                    }
                    break;
                case 3:
                    itrEst = estudianteA.iterator();
                    System.out.println("Actualmente tenemos registrados " + estudianteA.size() + " estudiantes");
                    while (itrEst.hasNext()){
                        Estudiante objEst = itrEst.next();
                        objEst.saberPromedio();
                    }
                    break;
                case 4:
                    double notasP = 0;
                    double promedioE = 0;
                    itrEst = estudianteA.iterator();
                    System.out.println("Actualmente tenemos registrados " + estudianteA.size() + " estudiantes");
                    while(itrEst.hasNext()){
                        Estudiante objEst = itrEst.next();
                        notasP += objEst.getPromedioEst();
                    }
                    promedioE = notasP / estudianteA.size();
                    System.out.println("El promedio general del grupo es de: " + promedioE);
                    break;
                case 5:
                    double mejorPromedio = 0;
                    String nombreEst = "";
                    itrEst = estudianteA.iterator();
                    System.out.println("Actualmente tenemos registrados " + estudianteA.size() + " estudiantes");
                    while(itrEst.hasNext()) {
                        Estudiante objEst = itrEst.next();
                        if(objEst.getPromedioEst() >= mejorPromedio){
                            mejorPromedio = objEst.getPromedioEst();
                            nombreEst = objEst.getNombreEst();
                        }
                    }
                    System.out.println("El estudiante con mejor promedio es: " + nombreEst + " con promedio de: " + mejorPromedio);
                        break;
                case 6:
                    // Especifico la ruta donde se va a guardar el archivo.
                    String filePath = "C:/Users/AngelDarkerZ/Desktop/datosEst.txt";
                    // Convertimos el ArrayList a un archivo de texto.
                    try (BufferedWriter esc = new BufferedWriter(new FileWriter(filePath))){
                        for (Estudiante objEst : estudianteA){
                            esc.write(objEst.toString());
                            esc.newLine();
                        }
                        System.out.println("ArrayList escrito en el archivo de manera exitosa");
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case  7:
                    salir = true;
                    break;
                default:
                    System.out.println("Selecciona una opción entre 1 y 7.");
                    break;
            }
            // Fin del switch.
        }
        // Fin del while.
    }
}
