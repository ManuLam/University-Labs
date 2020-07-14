package Q4;
public class Token {
   public static final int EOF = -1;
   public static final int IDENT = 10;
   public static final int IF = 11;
   public static final int INT = 12;
   public static final int REAL = 13;
   public static final int FOR = 14;
   public static final int WHILE = 15;
   public static final int DO = 16;
   public static final int CLASS = 17;
   public static final int PUBLIC = 18;
   public static final int STATIC = 19;
   public static final int VOID = 20;
   public static final int FLOAT = 21;
   public static final int LEFTCURLYBRACKET = 22;
   public static final int RIGHTCURLYBRACKET = 23;
   public static final int LEFTBRACKET = 24;
   public static final int RIGHTBRACKET = 25;
   public static final int LEFTSQUAREBRACKET = 26;
   public static final int RIGHTSQUAREBRACKET = 27;
   public static final int FULLSTOP = 28;
   public static final int SEMICOLON = 29;
   public static final int EQUAL = 30;
   public static final int DOUBLEEQUAL = 31;
   public static final int PLUS = 32;
   public static final int MINUS = 33;
   public static final int STAR = 34;
   public static final int FORWARDSLASH = 35;
   public static final int FLOATING = 36;
   public static final int ALL = 37;
   public static final int STRINGLITERAL = 38;
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
