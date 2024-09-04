import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k, t, w, answer;
    public static int f, s, g, u, d;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    // public static int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
    // public static int[] dy = {-2, -1, 2, 1, -2, -1, 2, 1};
    public static int[][] arr;
    public static int[][] map;
    public static boolean[][] visit;
    // public static int[] arr;
    // public static boolean[] visit;
    public static Queue<int[]> q = new LinkedList<>();
    // public static Queue<Integer> q = new LinkedList<>();
    // public static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;

        arr = new int[9][9];
        
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int x = 0;
        int y = 0;
        int answer = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (answer <= arr[i][j]) {
                    answer = arr[i][j];
                    x = i + 1;
                    y = j + 1;
                }
            }
        }
        
        System.out.println(answer);
        System.out.println(x + " " + y);
    }
}
    
    
