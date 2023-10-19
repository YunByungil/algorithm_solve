import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int[] arr = new int[26];
        String str = br.readLine();
        
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0' - '0' - 1;
            arr[num]++;
        }
        
        for (int i : arr) {
            System.out.print(i + " ");
        }
        
    }
}
