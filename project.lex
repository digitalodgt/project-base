package Project;

import java_cup.runtime.Symbol;

%%

%cup

%state COMMENT
%state STRING
%state STRINGREST

COMMA = ","
DOT = "."
SEMI = ";"
COMS = [^{SEMI}]+
WHITE = (" "|\t|\n|\r)
QUOT = "\""
CHARS = [^{QUOT}]+
ALPHA = [a-zA-Z0-9]
ALL = +
DIGIT = [0-9]
DIST = {DIGIT}+{DOT}*{DIGIT}*
%%


<YYINITIAL>"Km"   		{ return new Symbol( sym.KMS );   		}

<YYINITIAL>"carretera a"   	{ return new Symbol( sym.CARRETERA );   	}

<YYINITIAL>"residenciales"	{ return new Symbol( sym.RESIDENCIALES ); 	}

<YYINITIAL>"condominio"		{ return new Symbol( sym.CONDOMINIO ); 		}

<YYINITIAL>{SEMI}		{ yybegin( STRINGREST );			}

<STRINGREST>{COMS}		{ return new Symbol( sym.STR_CONST2, yytext() );}

<STRINGREST>{SEMI}		{ yybegin( YYINITIAL );				}

<YYINITIAL> {DIST}  		{ return new Symbol( sym.DIST, yytext() ); 	}

<YYINITIAL>{QUOT}		{ yybegin( STRING );				}

<STRING>{CHARS}			{ return new Symbol( sym.STR_CONST, yytext() );	}

<STRING>{QUOT}			{ yybegin( YYINITIAL);				}

<YYINITIAL>{COMMA}  		{ return new Symbol( sym.COMMA ); 		}

<YYINITIAL>{DOT}   		{ return new Symbol( sym.DOT );   		}

<YYINITIAL>"#"			{ yybegin( COMMENT );				}

<COMMENT>.		    	{ 						}

<COMMENT>\n		    	{ yybegin( YYINITIAL );				}

<YYINITIAL>{WHITE}		{  						}

<YYINITIAL>.        		{ System.out.println("Found: " + yytext()); 	}
