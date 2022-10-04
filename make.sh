export CLASSPATH=$CLASSPATH:/usr/class/cc4/cool/lib/java-cup-11a.jar:/usr/class/cc4/cool/lib/jlex.jar 
java JLex.Main project.lex
mv project.lex.java Yylex.java
java java_cup.Main project.cup
javac -d . Pair.java parser.java sym.java Yylex.java Main.java
