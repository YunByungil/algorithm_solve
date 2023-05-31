import java.util.*;
import java.io.*;

public class Main {
    public static int n, m; // n: 세로, m: 가로
    public static int max;
    public static int[][] arr; // 판
    public static int[][][] block = {
        {{0, 0}, {0, 1}, {1, 0}, {1, 1}}, // 네모
        {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
        {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
        {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
        {{0, 0}, {0, 1}, {0, 2}, {-1, 1}},
        {{0, 0}, {1, 0}, {2, 0}, {1, 1}},
        {{0, 0}, {1, 0}, {2, 0}, {1, -1}},
        {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
        {{0, 0}, {1, 0}, {1, -1}, {2, -1}},
        {{0, 0}, {0, -1}, {1, -1}, {1, -2}},
        {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
        {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
        {{0, 0}, {1, 0}, {2, 0}, {2, -1}},
        {{0, 0}, {1, 0}, {0, 1}, {0, 2}},
        {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
        {{0, 0}, {0, 1}, {1, 1}, {2, 1}},
        {{0, 0}, {0, 1}, {1, 0}, {2, 0}},
        {{0, 0}, {1, 0}, {1, 1}, {1, 2}},
        {{1, 0}, {1, 1}, {1, 2}, {0, 2}}
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
       
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        find();
      
    }
    
    public static void find() {
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < block.length; k++) {
                    int sum = 0;
                    for (int t = 0; t < 4; t++) {
                        int nx = i + block[k][t][0];
                        int ny = j + block[k][t][1];
                        
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                            continue;
                        }
                        
                        sum += arr[nx][ny];
                    }
                    
                    ans = Math.max(ans, sum);
                }
            }
        }
        
        System.out.println(ans);
    }
}