import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, t, k;
    public static int[][] arr, tmp;
    public static long[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        String input = br.readLine();
        String answer = "";
        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i);
            // System.out.println(num);
            if (60 <= num && num <= 90) {
                char str = (char) (num + 32);
                // System.out.println(str);
                answer += str;
                // System.out.println((char) num + 32);
            } else {
                char str = (char) (num - 32);
                // System.out.println(str);
                answer += str;
            }
        }
        
        System.out.println(answer);
    }
}
    
    
