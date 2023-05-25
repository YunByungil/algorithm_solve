import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static Map<Long, Integer> map = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            Long num = Long.parseLong(br.readLine());
            
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int min = 0;
        Long result = 0L;
        
        for (Long key : map.keySet()) {
            if (min < map.get(key)) {
                min = map.get(key);
                result = key;                
            } else if (min == map.get(key)) {
                result = Math.min(key, result);
            }
        }
        
        System.out.println(result);
    }    
}