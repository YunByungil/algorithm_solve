import java.util.*;
import java.io.*;

public class Main {
    public static int n, k, answer;
    public static int[] move = {-1, 1};
    public static int[] arr = new int[100_001];
    public static boolean[] visit = new boolean[100_001];
    public static Queue<Integer> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        visit[n] = true;
        q.offer(n);
        bfs();
        
        if (n == k) {
            System.out.println(0);
            return;
        }
        System.out.println(arr[k]);
        
    }
    
    public static void bfs() {
        while (!q.isEmpty()) {
            int nowY = q.poll();
            
            for (int i = 0; i < 1; i++) {
                int mulY = nowY * 2;

                if (mulY < 0 || mulY >= 100_001) {
                    continue;
                }

                if (!visit[mulY]) {
                    visit[mulY] = true;
                    arr[mulY] = arr[nowY];
                    q.offer(mulY);
                }
            }
            
            for (int i = 0; i < 2; i++) {
                int newY = nowY + move[i];
                
                if (newY < 0 || newY >= 100_001) {
                    continue;
                }
                
                if (!visit[newY]) {
                    visit[newY] = true;
                    arr[newY] = arr[nowY] + 1;
                    q.offer(newY);
                }
            }
            
            
        }
    }
}
