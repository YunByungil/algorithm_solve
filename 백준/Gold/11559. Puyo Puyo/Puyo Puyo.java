// "static void main" must be defined in a public class.
import java.util.*;
import java.io.*;

public class Main {
    public static class Point {
        int x;
        int y;
        char color;
        public Point(int y, int x, char color) {
            this.y = y;
            this.x = x;
            this.color = color;
        }
        
        public int getY() {
            return this.y;
        }
        
        public int getX() {
            return this.x;
        }
        
        public char getColor() {
            return this.color;
        }
    }
    public static int count, result;
    public static int[] col = {-1, 1, 0, 0};
    public static int[] row = {0, 0, 1, -1};
    public static char[][] arr;
    public static boolean[][] visit;
    public static List<Point> list = new ArrayList<>();
    public static Queue<Point> q = new LinkedList<>();
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[12][6];
        visit = new boolean[12][6];
        
        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        while (true) {
            boolean game = true;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (arr[i][j] != '.') {
                        bfs(i, j, arr[i][j]);
                        
                        if (count >= 4) {
                            game = false;
                            bomb();
                        }
                    }
                }
            }
            if (game) {
                break;
            }
            moveBlock();
            result++;
        }
        
        // for (int i = 0; i < 12; i++) {
        //     for (int j = 0; j < 6; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println(result);
        
    }
    
    public static void bfs(int y, int x, char c) {
        list = new ArrayList<>();
        count = 1;
        visit = new boolean[12][6];
        visit[y][x] = true;
        q.offer(new Point(y, x, c));
        list.add(new Point(y, x, c));
        while (!q.isEmpty()) {
            Point p = q.poll();
            
            int nowY = p.getY();
            int nowX = p.getX();
            
            for (int i = 0; i < 4; i++) {
                int newY = nowY + row[i];
                int newX = nowX + col[i];
                
                if (newY < 0 || newY > 11 || newX < 0 || newX > 5) {
                    continue;
                }
                
                if (arr[newY][newX] == '.') {
                    continue;
                }
                
                if (!visit[newY][newX] && arr[newY][newX] == c) {
                    visit[newY][newX] = true;
                    q.offer(new Point(newY, newX, arr[newY][newX]));
                    count++;
                    list.add(new Point(newY, newX, c));
                }
            }
        }
        
        // if (count >= 4) {
            // System.out.println("c : " + c);
        //     bomb();
        // }
        
    }
    
    public static void bomb() {
        for (Point p : list) {
            arr[p.getY()][p.getX()] = '.';
        }
        // moveBlock();
    }
    
    public static void moveBlock() {
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j > 0; j--) {
                if (arr[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (arr[k][i] != '.') {
                            arr[j][i] = arr[k][i];
                            arr[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}