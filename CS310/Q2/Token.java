/**
* The Token class stores all different values within ints 
* These stored "ints" are known as tokens and later used for the TokenID
*
* @author  Manu Lam
* @version 1.0
* @since   2018-11-21
*/
package Q2;
public class Token {

   public static final int IDENT = 10;
   public static final int IF = 11;
   public static final int INT = 12;
   public static final int REAL = 13;
   public static final int EOF = -1;

   private int tokenID;
   private Object value;

   public Token (int tokenID, Object value) {
      this.tokenID = tokenID;
      this.value = value;
   }

   public int    getTokenID () { return this.tokenID; }

   public Object getValue() { return this.value; }

   public String toString() {
      return "Token ID: |" + tokenID + "|" + " Token value: |" + value + "|";
   }
}
