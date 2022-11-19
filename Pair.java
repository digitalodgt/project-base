// (7)

// Puedo agregar clases personalizadas para ordenar mejor
// la informacion

// Estas deben pertenecer al paquete Project
// Tambien debo agregarlas en make.sh

package Project;

public class Pair {
    String nomb;
    String direc;

    public Pair(String w, String n) {
        this.nomb = w;
        this.direc = n;
    }

    // Es buena idea que les cree un metodo toString()
    // para poder visualizarlas facilmente en pantalla

    public String toString() {
        return "Alumno(a): " + String.format("%-40s",this.nomb) + "Direccion: Km. " + this.direc + "."+"\n";
    }
    
    public String getDir() {
    	return this.direc;
    }
    
    public String getNomb() {
    	return "Alumno(a): " + this.nomb;
    }
}
