package Project;

import java_cup.runtime.*;

import java.io.StringReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.*;
import java.util.regex.*;

import java.util.LinkedList;

class Categories {
    //Se declaran las variables globales
    public static Hashtable<String, LinkedList<Pair>> three;
    static int counter;

//Se crea el constructor de la clase Categories para inicializar las variables globales
    public Categories() {
        three = new Hashtable<String, LinkedList<Pair>>();
        counter = 0;
    }
    //Se crea el método classify
    static void classify(Pair input) {
    	boolean ruta1 = false;
    	boolean ruta2 = false;
    	boolean ruta3 = false;
    	LinkedList<Pair> llist = new LinkedList<Pair>();
	String carr = input.getDir();
	
	if((carr.indexOf("Santa Elena Barillas") != -1) | (carr.indexOf("El Salvador") != -1) ){
		ruta1 = true;
	}
	
	if(carr.indexOf("San Jose Pinula") != -1){
		ruta2 = true;
	}
	
	System.out.println(ruta1);
        Double kms = new Double(input.getDir().substring(0,4).trim());
        
        if (kms >= 18.5 & ruta1) {
            if (three.containsKey("Bus 1")) {
                llist = three.get("Bus 1");
                llist.add(input);
                counter += 1;
            } else {
                llist.add(input);
                three.put("Bus 1", llist);
                counter += 1;
            }
        }
        
        if ((kms >= 11.5 & kms<18.5) | ruta2) {
            if (three.containsKey("Bus 2")) {
                llist = three.get("Bus 2");
                llist.add(input);
                counter += 1;
            } else {
                llist.add(input);
                three.put("Bus 2", llist);
                counter += 1;
            }
        }
        
        if (kms < 11.5) {
            if (three.containsKey("Bus 3")) {
                llist = three.get("Bus 3");
                llist.add(input);
                counter += 1;
            } else {
                llist.add(input);
                three.put("Bus 3", llist);
                counter += 1;
            }
        }
    }
    
    static void printBus1(){
        if (three.containsKey("Bus 1")) {
            System.out.println("Bus 1: " + three.get("Bus 1"));
        } else {
            System.out.println("NO HAY ALUMNOS EN EL BUS 1");
        }
    }
    static void printBus2(){
        if (three.containsKey("Bus 2")) {
            System.out.println("Bus 2: " + three.get("Bus 2"));
        } else {
            System.out.println("NO HAY ALUMNOS EN EL BUS 2");
        }
    }
    static void printBus3(){
        if (three.containsKey("Bus 3")) {
            System.out.println("Bus 3: " + three.get("Bus 3"));
        } else {
            System.out.println("NO HAY ALUMNOS EN EL BUS 3");
        }
    }
}

public class Main {

  static Categories cat = new Categories();  

  public static void main(String args[]) throws Exception {
  
    FileInputStream fis = new FileInputStream(args[0]);

    parser p = new parser(new Yylex(fis));
        
    Symbol root = p.parse();

    LinkedList lista = (LinkedList)(root.value);

    for (int i = 0; i < lista.size(); i++) {
        Pair data = (Pair)(lista.get(i));
    	cat.classify(data);
        }
    
    cat.printBus1();
    cat.printBus2();
    cat.printBus3();
    }
}
