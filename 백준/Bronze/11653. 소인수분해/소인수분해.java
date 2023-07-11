import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        int num = 2;
        StringBuilder sb = new StringBuilder();
        while (n > 1) {
            if (n % num == 0) {
                n /= num;
                sb.append(num).append("\n");
            } else {
                num++;
            }
        }
        System.out.println(sb);
        
    }
}
