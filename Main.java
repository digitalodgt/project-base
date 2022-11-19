package Project;

import java_cup.runtime.*;

import java.io.StringReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.*;
import java.util.regex.*;
import java.util.Enumeration;
import java.util.LinkedList;

class Categories {
    //Se declaran las variables globales
    public static Hashtable<String, LinkedList<Pair>> three;
    static int counter1;
    static int counter2;
    static int counter3;
    static int counterNB;

//Se crea el constructor de la clase Categories para inicializar las variables globales
    public Categories() {
        three = new Hashtable<String, LinkedList<Pair>>();
        counter1 = 0;
        counter2 = 0;
        counter3 = 0;
        counterNB = 0;
    }
    //Se crea el método classify
    static void classify(Pair input) {
    	boolean ruta1 = false;
    	boolean ruta2 = false;
    	boolean ruta3 = false;
    	LinkedList<Pair> llist = new LinkedList<Pair>();
	String carr = input.getDir();
	
	if((carr.indexOf("Santa Elena Barillas") != -1) | (carr.indexOf("El Salvador") != -1) | (carr.indexOf("Villa Canales") != -1) ){
		ruta1 = true;
	}
	
	if(carr.indexOf("San Jose Pinula") != -1 | (carr.indexOf("Lo de Dieguez") != -1) | (carr.indexOf("Pavon") != -1) | (carr.indexOf("Fraijanes") != -1)){
		ruta2 = true;
	}
	
        Double kms = new Double(input.getDir().substring(0,4).trim());
        
        if (kms >= 18.5 & kms <= 31 & ruta1) {
            if (three.containsKey("Bus 1")) {
                llist = three.get("Bus 1");
                llist.add(input);
                counter1 += 1;
            } else {
                llist.add(input);
                three.put("Bus 1", llist);
                counter1 += 1;
            }
        }
        
        if ((kms >= 16.6 & kms<18.5) | ruta2) {
            if (three.containsKey("Bus 2")) {
                llist = three.get("Bus 2");
                llist.add(input);
                counter2 += 1;
            } else {
                llist.add(input);
                three.put("Bus 2", llist);
                counter2 += 1;
            }
        }
        
        if (kms < 16.6 & kms != 0 & ((carr.indexOf("El Salvador") != -1) | (carr.indexOf("Piedra Parada") != -1))) {
            if (three.containsKey("Bus 3")) {
                llist = three.get("Bus 3");
                llist.add(input);
                counter3 += 1;
            } else {
                llist.add(input);
                three.put("Bus 3", llist);
                counter3 += 1;
            }
        }
        
        if (kms == 0 | kms >31 | (carr.indexOf("El Atlantico") != -1)) {
            if (three.containsKey("No hay bus")) {
                llist = three.get("No hay bus");
                llist.add(input);
                counterNB += 1;
            } else {
                llist.add(input);
                three.put("No hay bus", llist);
                counterNB += 1;
            }
        }
    }
    
    static void printBus1(){
    	LinkedList<Pair> llist = new LinkedList<Pair>();
    	
    	llist = three.get("Bus 1");
    	
        if (three.containsKey("Bus 1")) {
            	System.out.println("Bus 1:");
        
            	for (int i = 0; i < llist.size(); i++){
        		System.out.print(llist.get(i));
		}
		System.out.println("Total Alumnos Bus 1: " + counter1);
        } else {
            System.out.println("NO HAY ALUMNOS EN EL BUS 1");
        }
    }
    
    static void printBus2(){
    	LinkedList<Pair> llist = new LinkedList<Pair>();
    	
    	llist = three.get("Bus 2");
    	
        if (three.containsKey("Bus 2")) {
            	System.out.println("Bus 2:");
        
            	for (int i = 0; i < llist.size(); i++){
        		System.out.print(llist.get(i));
		}
		System.out.println("Total Alumnos Bus 2: " + counter2);
        } else {
            System.out.println("NO HAY ALUMNOS EN EL BUS 2");
        }
    }
    
    static void printBus3(){
    	LinkedList<Pair> llist = new LinkedList<Pair>();
    	
    	llist = three.get("Bus 3");
    	
        if (three.containsKey("Bus 3")) {
            	System.out.println("Bus 3:");
        
            	for (int i = 0; i < llist.size(); i++){
        		System.out.print(llist.get(i));
		}
		System.out.println("Total Alumnos Bus 3: " + counter3);
        } else {
            System.out.println("NO HAY ALUMNOS EN EL BUS 3");
        }
    }
    
    static void printNoBus(){
    	LinkedList<Pair> llist = new LinkedList<Pair>();
    	
    	llist = three.get("No hay bus");
    	
        if (three.containsKey("No hay bus")) {
            	System.out.println("No hay bus:");
        
            	for (int i = 0; i < llist.size(); i++){
        		System.out.println(llist.get(i).getNomb());
		}
		System.out.println("Total Alumnos sin Bus: " + counterNB);
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
    
    System.out.print("\033[H\033[2J");  
    System.out.flush(); 
    cat.printBus1();
    cat.printBus2();
    cat.printBus3();
    cat.printNoBus();
    }
}
