import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (list.contains(input)) {
                continue;
            }
            
            list.add(input);
        }

        // Collections.sort(list, new Comparator<String>() {
        //     @Override
        //     public int compare(final String o1, final String o2) {
        //         if (o1.length() < o2.length()) {
        //             // System.out.println("o2 = " + o2);
        //             return -1;
        //         } else if (o1.length() == o2.length()) {
        //             return o1.compareTo(o2);
        //         }
        //         return 0;
        //     }
        // });
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(final String o1, final String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                } else if (o1.length() > o2.length()) {
                    return 1;
                } else {
                    return o1.compareTo(o2);                    
                }
            }
        });
        for (String str : list) {
            System.out.println(str);
        }
    }
}
