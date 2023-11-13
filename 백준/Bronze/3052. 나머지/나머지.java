import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        List<Integer> list = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            int mod = num % 42;
            if (!list.contains(mod)) {
                answer++;
            }
            list.add(mod);
            
        }
        
        System.out.println(answer);
    }
}
