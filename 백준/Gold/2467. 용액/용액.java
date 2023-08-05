import java.util.*;
import java.io.*;

public class Main {
    public static int n, max;
    public static int[] arr;
    public static int[] sorted;
    public static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        max = Integer.MAX_VALUE;
        arr = new int[n];
        sorted = new int[n];
        answer = new int[2];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sorted[i] = arr[i];
        }
        Arrays.sort(sorted);
        
        int start = 0;
        int end = n - 1;
        
        int resultS = 0;
        int resultE = 0;
        int nowTem = 0;
        
        while (start < end) {
            nowTem = sorted[start] + sorted[end];
            int check = Math.abs(nowTem);
            
            if (max >= check) {
                max = check;
                resultS = start;
                resultE = end;
            }
            
            if (nowTem == 0) {
                break;
            } else if (nowTem > 0) {
                end--;
            } else if (nowTem < 0) {
                start++;
            }
        }
        
        System.out.println(sorted[resultS] + " " + sorted[resultE]);
        
    }
}    
