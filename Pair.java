// (7)

// Puedo agregar clases personalizadas para ordenar mejor
// la informacion

// Estas deben pertenecer al paquete Project
// Tambien debo agregarlas en make.sh

package Project;

public class Pair {
    String word;
    int num;

    public Pair(String w, int n) {
        this.word = w;
        this.num = n;
    }

    // Es buena idea que les cree un metodo toString()
    // para poder visualizarlas facilmente en pantalla

    public String toString() {
        return "Pair: <" + this.word + ", " + this.num + ">";
    }
}