package Project;

import java_cup.runtime.Symbol;

%%

%cup

%state COMMENT
%state STRING

COMMA = ","
DOT = "."
WHITE = (" "|\t|\n|\r)

ALPHA = [a-zA-Z]
DIGIT = [0-9]

%%



<YYINITIAL>{DIGIT}+ { 
                        // En el archivo .cup nuestro terminal NUM fue declarado como Integer
                        // por lo tanto necesitamos un numero como lexema

                        return new Symbol(
                            sym.NUM,
                            Integer.parseInt(yytext())
                        ); 
                    }


<YYINITIAL>{ALPHA}+ { 
                        // En el archivo .cup nuestro terminal WORD fue declarado como String
                        // por lo tanto necesitamos una cadena como lexema
                        // yytext() de por si ya es una cadena
                        
                        return new Symbol( 
                            sym.WORD, 
                            yytext() 
                        ); 
                    }

/* Estos solo se declararon como terminal, sin tipo, por lo que no necesitan lexema */

<YYINITIAL>{COMMA}  { return new Symbol( sym.COMMA ); }
<YYINITIAL>{DOT}   	{ return new Symbol( sym.DOT );   }

<YYINITIAL>{WHITE}  	{  }