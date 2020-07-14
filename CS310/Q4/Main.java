package Q4;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
    public static void main (String args[]) {
       FileInputStream fin = null;
       if ((args == null) || (args.length != 1)) {
          System.out.println ("Usage: java test <input-file>");
          System.exit (-1);
       }
       try {
          fin = new FileInputStream (args[0]);
          Reader input = new InputStreamReader(fin);
          Yylex lexer = new Yylex (input);

          Token currentToken = null;
          while ( (currentToken = lexer.yylex()).getTokenID() != Token.EOF)
             System.out.println (currentToken);

       } catch (IOException ioe) {
           System.out.println ("Error opening input file: " + args[0]);
       } catch (Exception e) {
           System.out.println ("Error analysing input: " + e.getMessage());
       }
       finally {
           try { fin.close(); } catch (Exception e) {}
       }
    }
}
