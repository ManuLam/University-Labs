/*---- Java preamble code ----*/
package Q3;
%%

/*---- Options and directives ----*/
%type Token // return a Token

/* The code included in %eofval{....}%eofval will be copied verbatim into the scanning method and will be
executed each time when the end of file is reached. The code returns a Token that indicates the end of file. */
%eofval{
  {return new Token (Token.EOF, null);}
%eofval}

/* The following declares a state called COMMENT - the lexical analyser can match different rules depending on the
   state it is in. */
%state COMMENT 

/* Macro for digits **/
digits=[0-9]+
all = [a-zA-Z0-9]+

%%
/*---- Actions ----*/
/* The initial scanning state is YYINITIAL */

<YYINITIAL>"if"             {return new Token (Token.IF, yytext());}
<YYINITIAL>"for"			{return new Token (Token.FOR, yytext());}
<YYINITIAL>"while"			{return new Token (Token.WHILE, yytext());}
<YYINITIAL>"do"				{return new Token (Token.DO, yytext());}
<YYINITIAL>"class"			{return new Token (Token.CLASS, yytext());}
<YYINITIAL>"public"			{return new Token (Token.PUBLIC, yytext());}
<YYINITIAL>"static"			{return new Token (Token.STATIC, yytext());}
<YYINITIAL>"void"			{return new Token (Token.VOID, yytext());}
<YYINITIAL>"float"			{return new Token (Token.FLOAT, yytext());}
<YYINITIAL>"{"             	{return new Token (Token.LEFTCURLYBRACKET, yytext());}
<YYINITIAL>"}"             	{return new Token (Token.RIGHTCURLYBRACKET, yytext());}
<YYINITIAL>"("             	{return new Token (Token.LEFTBRACKET, yytext());}
<YYINITIAL>")"             	{return new Token (Token.RIGHTBRACKET, yytext());}
<YYINITIAL>"["              {return new Token (Token.LEFTSQUAREBRACKET, yytext());}
<YYINITIAL>"]"              {return new Token (Token.RIGHTSQUAREBRACKET, yytext());}
<YYINITIAL>"."              {return new Token (Token.FULLSTOP, yytext());}
<YYINITIAL>";"             	{return new Token (Token.SEMICOLON, yytext());}
<YYINITIAL>"="             	{return new Token (Token.EQUAL, yytext());}
<YYINITIAL>"=="            	{return new Token (Token.DOUBLEEQUAL, yytext());}
<YYINITIAL>"+"           	{return new Token (Token.PLUS, yytext());}
<YYINITIAL>"-"            	{return new Token (Token.MINUS, yytext());}
<YYINITIAL>"*"           	{return new Token (Token.STAR, yytext());}
<YYINITIAL>"/"            	{return new Token (Token.FORWARDSLASH, yytext());}

<YYINITIAL>("\""{all}"\"")	{return new Token (Token.STRINGLITERAL, yytext());}

<YYINITIAL>"/*"               {yybegin(COMMENT);} /*yybegin sets the current state */
<YYINITIAL>[_a-z][_a-zA-Z0-9]*   {return new Token (Token.IDENT, yytext());}

<YYINITIAL>{digits}           {return new Token (Token.INT, new Integer (yytext()));}
<YYINITIAL>({digits}"."[0-9]*)|([0-9]*"."{digits})	{return new Token (Token.REAL, new Double (yytext()));}
<YYINITIAL>[\r\n\t\ ]+    {}

<COMMENT>"*/"     {yybegin(YYINITIAL);}
<COMMENT>.        {}
. {}