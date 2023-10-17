import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= 2 * (n - i); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        for (int i = n - 1; i >= 1; i--) { // i = 4, 3, 2, 1
            for (int j = 2; j <= i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= 2 * (n - i); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
