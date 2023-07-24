import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, answer;
    public static int[] a, b;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];
        b = new int[m];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(b);
        
        for (int i = 0; i < n; i++) {
            binarySearch(a[i]);
        }
        
        System.out.println(answer);
        System.out.println(sb);
    }
    
    public static void binarySearch(int num) {
        int start = 0;
        int end = b.length;
        
        while (start < end) {
            int mid = (start + end) / 2;
            
            if (b[mid] == num) {
                return;
            } else if (b[mid] > num) {
                end = mid;
            } else if (b[mid] < num) {
                start = mid + 1;
            }
        }
        answer++;
        sb.append(num).append(" ");
    }
}
