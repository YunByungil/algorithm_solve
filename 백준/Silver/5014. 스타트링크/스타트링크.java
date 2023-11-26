import java.util.*;
import java.io.*;

public class Main {
    public static int f, g, s, u, d; 
    // f층으로 이루어진 사무실, g층에 위치, 현재 위치는 s층 엘베 u, d버튼
    // g층에 도착하려면 버튼을 적어도 몇 번 눌러야 하는지 구하는 프로그램
    public static int[] move = new int[2];
    public static boolean[] visit;
    public static int[] arr;
    public static Queue<Integer> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        
        if (s == g) {
            System.out.println(0);
            return;
        }
        arr = new int[f + 1];
        visit = new boolean[f + 1];
        move[0] = u;
        move[1] = -d;
        q.offer(s);
        bfs();

        // for (int i = 1; i <= f; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();
        
        int answer = arr[g];
        if (answer == 0) {
            System.out.println("use the stairs");
        } else {
            System.out.println(answer);
        }
    }
    
    public static void bfs() {
        while (!q.isEmpty()) {
            int nowLocation = q.poll();
            visit[nowLocation] = true;
            
            for (int i = 0; i < 2; i++) {
                int newLocation = nowLocation + move[i];
                
                if (newLocation <= 0 || newLocation > f) {
                    continue;
                }
                
                if (!visit[newLocation]) {
                    arr[newLocation] = arr[nowLocation] + 1;
                    q.offer(newLocation);
                    visit[newLocation] = true;
                }
            }
        }
        
        
    }
}
