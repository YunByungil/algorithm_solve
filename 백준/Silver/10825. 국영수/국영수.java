import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        // String[][] arr = new {
        //     {"1", "1", "1", "1"},
        //     {"2", "2", "2", "2"}
        // };
        // String[][] arr = {
        //     {"1", "1", "1", "1"}, {"2", "2", "2", "2"}
        // };
        
        String[][] arr = new String[n][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                String input = st.nextToken();
                arr[i][j] = input;
            }
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            if (Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) {
                if (Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])) {
                    if (Integer.parseInt(o1[3]) == Integer.parseInt(o2[3])) {
                        return o1[0].compareTo(o2[0]);
                    }
                    return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
                }
                return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
            }
            return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
        });
        
        
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0]);
        }
        
	}
}
    
    
