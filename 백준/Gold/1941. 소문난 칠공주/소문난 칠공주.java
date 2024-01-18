import java.util.*;
import java.io.*;

public class Main {
    public static int n, answer;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static String[][] arr = new String[5][5];
    public static boolean[][] visit = new boolean[5][5];
    public static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < 5; j++) {
                arr[i][j] = input.charAt(j) + "";
            }
        }
        
        dfs(0, 0);
        System.out.println(answer);
    }
    
    public static void dfs(int depth, int start) {
        if (depth == 7) {
            if (check()) answer++;
            return;
        } 
        
        for (int i = start; i < 25; i++) {
            // System.out.println(i + " / " + 5 + " = " + (i / 5));
            // System.out.println(i + " % " + 5 + " = " + (i % 5));
            visit[i / 5][i % 5] = true;
            dfs(depth + 1, i + 1);
            visit[i / 5][i % 5] = false;
        }
    }
    
    public static boolean check() {
        boolean[][] copy = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            copy[i] = visit[i].clone();
        }
        
        int x = 0, y = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (copy[i][j]) {
                    x = i;
                    y = j;
                }
            }
        }
        
        
        q = new LinkedList<>();
        q.add(new int[]{x, y});
        
        int count = 0;
        int s = 0;
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int newX = nowLocation[0] + dx[i];
                int newY = nowLocation[1] + dy[i];
                
                if (newX < 0 || newX >= 5 || newY < 0 || newY >= 5) {
                    continue;
                }
                
                if (copy[newX][newY]) {
                    if (arr[newX][newY].equals("S")) {
                        s++;
                    }
                    count++;
                    q.offer(new int[]{newX, newY});
                    copy[newX][newY] = false;
                }
            }
        }
        if (count == 7 && s >= 4) {
            return true;
        }
        
        return false;
    }
}
    
    
