import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static boolean[] visit;
    public static int[] arr;
    public static int[] move = {-1, 1, 2};
    public static Queue<Integer> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[100_001];
        visit = new boolean[100_001];
        
        visit[n] = true;
        q.offer(n);
        bfs();
        
        //for (int i = 0; i <= 20; i++) {
          //  System.out.println("arr[" + i + "] = " + arr[i]);
        //}
         System.out.println(arr[k]);
    }
    
    public static void bfs() {
        while (!q.isEmpty()) {
            int nowLocation = q.poll();
            
            int left = nowLocation + move[0];
            int right = nowLocation + move[1];
            int jump = nowLocation * move[2];
            
            // if (left < 0 || right >= 100_001 || jump >= 100_001) {
            //     continue;
            // }

            if (left >= 0) {
            if (!visit[left]) {
                arr[left] = arr[nowLocation] + 1;
                q.offer(left);
                visit[left] = true;
            }
            }
            
            if (right < 100_001) {
            if (!visit[right]) {
                arr[right] = arr[nowLocation] + 1;
                q.offer(right);
                visit[right] = true;
            }
            }
            
            if (jump < 100_001) {
            if (!visit[jump]) {
                arr[jump] = arr[nowLocation] + 1;
                q.offer(jump);
                visit[jump] = true;
            }
            }
        }
    }
}
