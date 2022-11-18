package Project;

import java_cup.runtime.*;

import java.io.StringReader;
import java.io.IOException;
import java.io.FileInputStream;

import java.util.LinkedList;

public class Main {

  public static void main(String args[]) throws Exception {

    FileInputStream fis = new FileInputStream(args[0]);

    parser p = new parser(new Yylex(fis));
        
    Symbol root = p.parse();

    // (5)

    // La lista que venimos generando y emitiendo desde el parser

    //System.out.println("Desde nuestro main: ");
    //System.out.println(root.value);

    // Si pongo solo root.value aqui abajo, no me funciona
    // Me recuerdo... todo lo que voy emitiendo para Java es un Object
    // Necesito el type cast para recordarle que en realidad es una lista

    LinkedList lista = (LinkedList)(root.value);
    for (int i = 0; i < lista.size(); i++) {
        Pair data = (Pair)(lista.get(i));
    	System.out.println(data.getDir());
        }
    }
}
