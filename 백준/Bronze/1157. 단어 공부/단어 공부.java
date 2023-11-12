import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        String input = br.readLine();
        input = input.toLowerCase();
        int[] arr = new int[26];
        
        for (int i = 0; i < input.length(); i++) {
            int index = input.charAt(i) - 'a';
            arr[index]++;
        }
        
        int max = 0;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                continue;
            }
            
            if (count < arr[i]) {
                count = arr[i];
                max = i;
            }
        }
        
        int check = 0;
        int index = 0;
        for (int i = 0; i < 26; i++) {
            if (check < arr[i]) {
                check = arr[i];
                index = i;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            if (i == index) {
                continue;
            }
            
            if (check == arr[i]) {
                System.out.println("?");
                return;
            }
        }
        System.out.println((char) (max + 'A'));
        
        
    }
}
