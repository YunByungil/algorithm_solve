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
    public static String[][] arr;
    public static boolean[][] visit;
    // public static int[] arr;
    // public static boolean[] visit;
    public static Queue<int[]> q = new LinkedList<>();
    // public static Queue<Integer> q = new LinkedList<>();
    // public static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;

        arr = new String[5][15];
        
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                arr[i][j] = input.charAt(j) + "";
            }
        }
        
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] == null) {
                    System.out.print("");
                    continue;
                }
                System.out.print(arr[j][i]);
            }
        }
        
    }
}
    
    
