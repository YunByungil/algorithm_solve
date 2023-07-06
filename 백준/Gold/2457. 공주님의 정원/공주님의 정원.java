import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        
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
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < 2; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        int start = 301;
        int endDay = 1201;
        int max = 0;
        int index = 0;
        int count = 0;
        
        while (start < endDay) {
            boolean isFind = false;
            
            for (int i = index; i < n; i++) {
                if (arr[i][0] > start) {
                    break;
                }
                
                if (max < arr[i][1]) {
                    isFind = true;
                    max = arr[i][1];
                    index = i + 1;
                }
            }
            
            if (isFind) {
                start = max;
                count++;
            } else {
                break;
            }
        }
        
        if (max < endDay) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }
        
    }
}
