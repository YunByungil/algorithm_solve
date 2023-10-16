import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                if (i == j) {
                    sb.append("*");
                    System.out.print(sb);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
