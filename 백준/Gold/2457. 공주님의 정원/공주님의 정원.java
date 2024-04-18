import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k, t, w;
    public static int[][] arr, tmp;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            
            int start = startMonth * 100 + startDay;
            int end = endMonth * 100 + endDay;
            arr[i][0] = start;
            arr[i][1] = end;
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            
            return o1[0] - o2[0];
        });
        
        int start = 301;
        int end = 1201;
        int index = 0;
        int answer = 0;
        
        while (start < end) {
            int next = start;
            for (int i = index; i < n; i++) {
                if (arr[i][0] <= start && arr[i][1] > next) {
                    next = arr[i][1];
                    index = i + 1;
                }
            }
            
            if (next == start) {
                System.out.println(0);
                return;
            }
            
            answer++;
            start = next;
        }
        
        System.out.println(answer);
    }
}
    
    
