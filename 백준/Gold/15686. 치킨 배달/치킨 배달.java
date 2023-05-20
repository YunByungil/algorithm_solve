// "static void main" must be defined in a public class.
import java.io.*;
import java.util.*;

public class Main {
    public static class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int n, m; // n: 크기, m: 최대 치킨 집 개수
    public static int[][] arr;
    public static ArrayList<Point> house = new ArrayList<>();
    public static ArrayList<Point> chicken = new ArrayList<>();
    public static int ans;
    public static boolean[] visit;
    
    
    public static void main(String[] args) throws IOException {
        // 0: 빈 칸, 1: 집, 2: 치킨집
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][n];
        visit = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                
                if (arr[i][j] == 1) {
                    house.add(new Point(i, j));
                } else if (arr[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }
        
        ans = Integer.MAX_VALUE;
        visit = new boolean[chicken.size()];
        
        dfs(0, 0);
        System.out.println(ans);
        
    }
    
    public static void dfs(int depth, int start) {
        if (depth == m) {
            int result = 0;
            
            for (int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;
                
                for (int j = 0; j < chicken.size(); j++) {
                    if (visit[j]) {
                        int resultX = Math.abs(house.get(i).x - chicken.get(j).x);
                        int resultY = Math.abs(house.get(i).y - chicken.get(j).y);
                        int distance = resultY + resultX;
                        
                        temp = Math.min(distance, temp);
                    }
                }
                result += temp;
            }
            ans = Math.min(ans, result);
            return;
        }
        
        for (int i = start; i < chicken.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, i);
                visit[i] = false;
            }
        }
        
    }
}