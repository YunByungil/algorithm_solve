import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int count = 0; count < t; count++) {
            int n = Integer.parseInt(br.readLine()); // 의상의 수 n
            Map<String, Integer> map = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                
                map.put(type, map.getOrDefault(type, 0) + 1);
            }
            
            int answer = 1;
            for (Integer value : map.values()) {
                answer *= (value + 1);
            }
            System.out.println(answer - 1);
        }
    }
}
