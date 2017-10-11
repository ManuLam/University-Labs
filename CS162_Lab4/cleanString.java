import java.util.Scanner;

public class cleanString {
public static void main(String[]args) {
    Scanner in = new Scanner(System.in);
    String sen = in.nextLine();
    
    System.out.println(checkArray(sen));  
            }


    public static String checkArray(String s) {
        if(s.length()<=1) {
            return s;
        }
        
        if(s.charAt(0)==s.charAt(1)) {
            return checkArray(s.substring(1));
            }
            
        else
        return s.charAt(0) + checkArray(s.substring(1));
    }
}