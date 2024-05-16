import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k, t, w;
    public static int[][] arr, tmp;
    // public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i][0] = start;
            arr[i][1] = end;
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            
            return o1[0] - o2[0];
        });
        
        int answer = 0;
        int start = arr[0][0];
        int end = arr[0][1];
        answer += end - start;
        
        for (int i = 1; i < n; i++) {
            int newStart = arr[i][0];
            int newEnd = arr[i][1];
            
            if (start <= newStart && newEnd <= end) {
                continue;
            }
            
            if (newStart < end) {
                answer += newEnd - end;
            }
            
            else {
                answer += newEnd - newStart;
            }
            
            start = newStart;
            end = newEnd;
        }
        
        System.out.println(answer);
    }
}
    
    
