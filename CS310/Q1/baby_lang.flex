/* --------------------------Usercode Section------------------------ */

/* Code in this section will be added to the top of the generated Java class */
package Q1;
%%

/* -----------------Options and Declarations Section----------------- */

/* Specifies that the return type of the method yylex() will be void and not Yytoken */
%type Void
%class diffClassName
%function diffFunctionName

/* regular expressions [macros] for a letter and a new line */
letterDigit = [A-Za-z0-9]
word = {letterDigit}+
newline = \r|\n|\r\n

%%

/* ------------------------Lexical Rules Section---------------------- */

/* Print the text matched by the current rule */ 
{word} {System.out.println(yytext());}

/* Ignore (do nothing) with newline */
{newline} {}

/* Ignore (do nothing) for any other character (dot represented any char other than a new line) */
. {}