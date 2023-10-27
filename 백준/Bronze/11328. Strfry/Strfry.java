import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            int[] arr = new int[26];
            int[] result = new int[26];
            boolean b = false;
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            
            String input = st.nextToken();
            for (int j = 0; j < word.length(); j++) {
                int wordInt = word.charAt(j) - 'a';
                arr[wordInt]++;
            }
            
            for (int j = 0; j < input.length(); j++) {
                int inputInt = input.charAt(j) - 'a';
                result[inputInt]++;
            }
            
            for (int j = 0; j < 26; j++) {
                if (arr[j] != result[j]) {
                    b = true;
                    break;
                }
            }
            
            if (b) {
                sb.append("Impossible").append("\n");
            } else {
                sb.append("Possible").append("\n");
            }
        }
        
        
        System.out.println(sb);
    }
}
