import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            answer = 0;
            count = 0;
            for (int j = 0; j < input.length(); j++) {
                char result = input.charAt(j);
                if (result == 'O') {
                    answer += ++count;
                } else {
                    count = 0;
                }
            }
            
            System.out.println(answer);
        }
        
    }
}
