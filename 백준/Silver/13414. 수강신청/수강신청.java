import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 
        
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < m; i++) {
            String num = br.readLine();
            if (map.containsKey(num)) {
                map.remove(num);
                map.put(num, i);
            }
            map.put(num, i);
        }
        int count = 0;
        for (String i : map.keySet()) {
            if (count == n) {
                break;
            }
            count++;
            System.out.println(i);
        }
        
    }
}
