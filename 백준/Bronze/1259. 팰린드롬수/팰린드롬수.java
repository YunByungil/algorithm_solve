import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        while (true) {
            String num = br.readLine();
            
            if (num.equals("0")) {
                break;
            }
            
            String newNum = "";
            for (int i = num.length() - 1; i >= 0; i--) {
                newNum += num.charAt(i);
            }
            
            if (num.equals(newNum)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
            
        }
        
    }
}
