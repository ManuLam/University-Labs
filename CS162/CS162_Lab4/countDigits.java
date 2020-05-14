import java.util.Scanner;

public class countDigits {
public static void main(String[]args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    
    System.out.println("Res: "+ countRecursive(n));
            }

        public static int countRecursive(int s) {
        
        if(s<8) {
            return 0;
        }
        
        else if(s%10==8 && s/10%10 == 8 ) {
            return countRecursive(s/10) + 2;
        }
        else if(s%10==8) {
            return countRecursive(s/10) + 1;
        }
        
        else 
            return countRecursive(s/10);
    }
}