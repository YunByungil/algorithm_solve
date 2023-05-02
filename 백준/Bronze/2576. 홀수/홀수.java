import java.util.*;
import java.io.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < 7; i++) {
            int input = Integer.parseInt(br.readLine());
            
            if (input % 2 != 0) {
                sum += input;
                min = Math.min(min, input);
            }
        }
        
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}