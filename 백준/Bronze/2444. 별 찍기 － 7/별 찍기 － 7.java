import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            for (int k = n - 1; k > i; k--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * (i + 1)) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int k = n - 1; k > i; k--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * (i + 1)) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
