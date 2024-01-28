import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        String str = br.readLine();
        int length = str.length();
        int answer = 1;
        
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != sb.charAt(i)) {
                answer = 0;
            }
        }
        
        System.out.println(answer);
    }
}
    
    
