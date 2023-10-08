import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num % 2 != 0) {
                sum += num;
                min = Math.min(min, num);
            }
        }
        
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
        
        
    }
}
