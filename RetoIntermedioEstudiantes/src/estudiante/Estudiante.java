package estudiante;

public class Estudiante {

    // Declaración de variables.
    private int idEst;
    private String nombreEst;
    private int edadEst;
    private double promedioEst;

    // Constructor vacio.
    public Estudiante(){

    }

    // Constructor con parámetros.
    public Estudiante(int idEst, String nombreEst, int edadEst, double promedioEst) {
        this.idEst = idEst;
        this.nombreEst = nombreEst;
        this.edadEst = edadEst;
        this.promedioEst = promedioEst;
    }

    // Métodos getter y setter.
    public int getIdEst() {
        return idEst;
    }

    public void setIdEst(int idEst) {
        this.idEst = idEst;
    }

    public String getNombreEst() {
        return nombreEst;
    }

    public void setNombreEst(String nombreEst) {
        this.nombreEst = nombreEst;
    }

    public int getEdadEst() {
        return edadEst;
    }

    public void setEdadEst(int edadEst) {
        this.edadEst = edadEst;
    }

    public double getPromedioEst() {
        return promedioEst;
    }

    public void setPromedioEst(double promedioEst) {
        this.promedioEst = promedioEst;
    }

    // Método toString que muestra todos los datos.
    @Override
    public String toString() {
        return  "ID: " + idEst +
                " - Nombre: '" + nombreEst + '\'' +
                " - Edad: " + edadEst +
                " - Promedo: " + promedioEst +
                " - Estado: " + getEstado();
    }

    // Método para verificar si el estudiante aprobo.
    public void saberPromedio(){
        if(this.getPromedioEst() >= 3.0){
            System.out.println("El estudiante " + this.getNombreEst() + " aprobo.");
        }else{
            System.out.println("El estudiante " + this.getNombreEst() + " reprobo.");
        }
    }

    public boolean estaAprobado(){
        return  this.getPromedioEst() >= 3.0;
    }

    public String getEstado(){
        return estaAprobado() ? "Aprobado" : "Reprobado";
    }
}
