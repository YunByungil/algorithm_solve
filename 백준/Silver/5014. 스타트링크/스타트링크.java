import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k, t, w, answer;
    public static int f, s, g, u, d;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    // public static int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
    // public static int[] dy = {-2, -1, 2, 1, -2, -1, 2, 1};
    // public static int[][] arr;
    // public static boolean[][] visit;
    public static int[] arr;
    public static boolean[] visit;
    // public static Queue<int[]> q = new LinkedList<>();
    public static Queue<Integer> q = new LinkedList<>();
    public static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;

        // 총 f층 건물, G층으로 가야한다.
        // 지금 S층이고 엘베를 타고 G층을 간다.
        // U, D 두 개로 몇 번 눌러야 하는지 알아보자.
        // U는 위로 U층을 가는 버튼, D는 아래로 D층을 가는 버튼이다.
        
        // 총 f층, 위치 s, 가는 곳 g, 올라가기 u, 내려가기 d
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
        
        visit[s] = true;
        q.offer(s);
        
        bfs();
        
        int answer = arr[g];
        
        if (answer == 0) {
            System.out.println("use the stairs");
        } else {
            System.out.println(answer);
        }
        
    }
    
    public static void bfs() {
        while (!q.isEmpty()) {
            int now = q.poll();
            int move = 0;
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    move = now - d;
                } else if (i == 1) {
                    move = now + u;
                }
                
                if (move <= 0 || move > f) {
                    continue;
                }   

                if (!visit[move] && arr[move] == 0) {
                    arr[move] = arr[now] + 1;
                    visit[move] = true;
                    q.offer(move);
                }
            }
            
            
        }
    }
}
    
    
