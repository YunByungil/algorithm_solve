import java.util.*;
import java.io.*;

public class Main {
    public static int n, k; //  n: 수빈이 위치, k: 동생 위치
    public static int[] arr = new int[100_001]; // 좌표
    public static boolean[] visit = new boolean[100_001];
    public static int[] col = {1, -1, 2};
    public static Queue<Integer> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        
        
        bfs(n);
        System.out.println(arr[k]);
        
    }
    
    public static void bfs(int num) {
        boolean result = true;
        q.offer(num);
        arr[num] = 0;
        visit[num] = true;
        
        while (!q.isEmpty()) {
            if (!result) {
                break;
            }
            int nowLocation = q.poll();
            int move = 0;
            for (int i = 0; i < 3; i++) {
                if (i == 2) {
                    move = nowLocation * col[i];    
                } else {
                    move = nowLocation + col[i];
                }
                
                if (i == 2) {
                    
                    if (nowLocation > 50_000) {
                       continue;
                    }
                    
                    if (arr[move] == 0 && !visit[move]) {
                        q.offer(move);
                        visit[move] = true;
                        arr[move] = arr[nowLocation] + 1;
                    }
                    
                }
                
                else if (move < 0 || move > 100_000) {
                    continue;
                } else {
                    if (arr[move] == 0 && !visit[move]) {
                    q.offer(move);
                    visit[move] = true;
                    arr[move] = arr[nowLocation] + 1;
                }
                }
                
                
                if (move == k || move == k) {
                    result = false;
                    break;
                }
            }
        }
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
}