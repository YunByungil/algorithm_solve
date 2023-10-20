import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int[] arr = new int[10];
        int num = 1;
        for (int i = 0; i < 3; i++) {
            num *= Integer.parseInt(br.readLine());
        }
        String mul = String.valueOf(num);
        
        for (int i = 0; i < mul.length(); i++) {
            int index = mul.charAt(i) - '0';
            arr[index]++;
        }
        
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
