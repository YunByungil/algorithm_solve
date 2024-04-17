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
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(arr[0][1]);
		
		for(int i = 1; i < n; i++) {
			if(pq.peek() <= arr[i][0]) {
                
                pq.poll();
            }
			
			pq.add(arr[i][1]);
		}
        
		System.out.println(pq.size());
    }
}
    
    
