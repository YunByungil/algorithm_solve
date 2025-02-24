import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            boolean answer = true;
            int[] arr = new int[27];
            int[] arr2 = new int[27];
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            
            String strfry = st.nextToken();
            
            for (int j = 0; j < input.length(); j++) {
                int num = input.charAt(j) - 'a';
                arr[num]++;
            }
            
            for (int j = 0; j < strfry.length(); j++) {
                int num = strfry.charAt(j) - 'a';
                arr2[num]++;
            }
            
            for (int j = 0; j < 27; j++) {
                if (arr[j] != arr2[j]) {
                    answer = false;
                    break;
                }
            }
            
            if (answer) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
        
        
    }
}
