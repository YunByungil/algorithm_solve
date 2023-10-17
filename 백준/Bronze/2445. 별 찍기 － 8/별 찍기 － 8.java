import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int k = 0; k < (2 * n) - (i * 2); k++) {
                System.out.print(" ");
            }
            for (int r = 0; r < i; r++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }
            for (int k = 0; k < (2 * n) - (i * 2); k++) {
                System.out.print(" ");
            }
            for (int r = i; r > 0; r--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
