import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> arr = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (!arr.contains(word)) {
                arr.add(word);
            }
        }
        
        Collections.sort(arr, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });
        
        
        for (String str : arr) {
            System.out.println(str);
        }
    }
}