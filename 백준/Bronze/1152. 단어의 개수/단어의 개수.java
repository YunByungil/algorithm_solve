import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        String input = br.readLine();
        String[] words = input.split(" ");
        int answer = 0;
        for (String word : words) {
            if (word.equals("")) {
                continue;
            }
            answer++;
        }
        
        System.out.println(answer);
    }
}
