import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        
        int answer = 0;
        
        for (int i = 0; i < input.length(); i++) {
            answer += input.charAt(i) - '0';
        }
        System.out.println(answer);
    }
}
