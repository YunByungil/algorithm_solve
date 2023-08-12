import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String log = st.nextToken();
            
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        List<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) % 2 != 0) {
                list.add(s);
            }
        }
        
        Collections.sort(list, Collections.reverseOrder());
        for (String answer : list) {
            System.out.println(answer);
        }
    }
}
