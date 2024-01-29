import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                int a = 0;
                int b = 0;
                for (int i = 0; i < o1.length(); i++) {
                    int num1 = o1.charAt(i) - '0';
                    if (0 < num1 && num1 <= 9) {
                        a += num1;
                    }
                }
                for (int i = 0; i < o2.length(); i++) {
                    int num2 = o2.charAt(i) - '0';
                    if (0 < num2 && num2 <= 9) {
                        b += num2;
                    }
                }
                
                if (a == b) {
                    return o1.compareTo(o2);
                } else {
                    return a - b;
                }
                
            } else {
                return o1.length() - o2.length();
            }
            
        });

        for (String str : arr) {
            System.out.println(str);
        }
    }
}
    
    
