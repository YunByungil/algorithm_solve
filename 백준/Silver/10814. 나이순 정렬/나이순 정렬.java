import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());

        String[][] arr = new String[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 2; j++) {
                arr[i][j] = st.nextToken();
            }
        }
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(final String[] o1, final String[] o2) {
                if (Integer.parseInt(o1[0]) == Integer.parseInt(o2[0])) {
                    return 0;
                } else {
                    return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
                }
            }
        });

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
        
    }
}
