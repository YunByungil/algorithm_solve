import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[7][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[y][s]++;
        }
        
        int answer = 0;
        int zero = 0;
        
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < 2; j++) {
                if (arr[i][j] > 0) {
                    if (arr[i][j] >= k) {
                        answer += arr[i][j] / k;
                        if (arr[i][j] % k >= 1) {
                            answer ++;
                        }
                    } else {
                        answer++;
                    }
//                     if (arr[i][j] <= k) {
//                         answer++;
//                     }

//                     if (arr[i][j] > k) {
//                         answer += (arr[i][j] + 1) / k;
//                     }
                }
            }
        }
        
        System.out.println(answer);
        
    }
}
