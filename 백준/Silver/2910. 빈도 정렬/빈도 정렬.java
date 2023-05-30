import java.util.*;
import java.io.*;

public class Main {
    public static int n, c;
    public static List<Integer> list;
    public static Map<Integer, Integer>map = new LinkedHashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        list = new ArrayList<>(map.keySet());
        
        Collections.sort(list, new Comparator<>() {
           @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        
        for (int l : list) {
            for (int i = 0; i < map.get(l); i++) {
                System.out.print(l + " ");
            }
        }
    }
}