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
        return "Pair: <" + this.nomb + ", " + this.direc + ">";
    }
    
    public String getDir() {
    	return this.direc;
    }
}
