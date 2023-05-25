import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        String[] str = new String[n];
        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            str[i] = "" + sc.nextLong();
        }
        
        for (int i = 0; i < n; i++) {
            String num = str[i];
            str[i] = "";
            for (int j = num.length() - 1; j >= 0; j--) {
                str[i] += num.charAt(j) - '0';
            }
            arr[i] = Long.parseLong(str[i]);
        }
        
        Arrays.sort(arr);
        
        for (Long i : arr) {
            System.out.println(i);
        }
    }    
}