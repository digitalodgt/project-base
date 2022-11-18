package Project;

import java_cup.runtime.*;

import java.io.StringReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.*;
import java.util.regex.*;

import java.util.LinkedList;

public class Main {
  
  public static void main(String args[]) throws Exception {

    FileInputStream fis = new FileInputStream(args[0]);

    parser p = new parser(new Yylex(fis));
        
    Symbol root = p.parse();

    LinkedList lista = (LinkedList)(root.value);
    /*for (int i = 0; i < lista.size(); i++) {
        Pair data = (Pair)(lista.get(i));
    	System.out.println(data.getDir());
        }*/
    }
}
