import java.util.*;
import java.io.*;

public class Main {
    public static int h, n, m;
    public static int min = Integer.MAX_VALUE;
    public static int[][][] arr;
    public static int[][][] map;
    public static int[][][] result;
    public static boolean[] visit;
    public static int[] row = {0, 0, 0, 0, 1, -1};
    public static int[] col = {0, 0, 1, -1, 0, 0};
    public static int[] ver = {1, -1, 0, 0, 0, 0};
    public static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        h = 5;
        n = 5;
        m = 5;
        visit = new boolean[h];
        arr = new int[h][n][m];
        map = new int[h][n][m];
        result = new int[h][n][m];

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[k][i][j] = Integer.parseInt(st.nextToken());

                }
            }
        }


//        for (int k = 0; k < h; k++) {
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.print(arr[k][i][j] + " ");
//                }
//                System.out.println();
//            }
//        }
//        System.out.println("==================");
        dfs(0);
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        System.out.println(min);

    }

    public static void dirCheck(int cnt) {
        if (cnt == 5) {
            bfs();
            return;
        }

        for (int i = 0; i < 4; i++) {
//            System.out.println("i = " + i);
            rotate(cnt);
            dirCheck(cnt + 1);
        }
    }

    public static void dfs(int depth) {
        if (depth == 5) {
            dirCheck(0);
            return;
        }

        for (int i = 0; i < h; i++) {
            if (!visit[i]) {
                visit[i] = true;
                map[depth] = arr[i].clone();
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }


    public static void bfs() {
        if (map[0][0][0] != 1) {
            return;
        }
        boolean[][][] v = new boolean[h][n][m];
        v[0][0][0] = true;
        result = new int[h][n][m];
        q.offer(new int[]{0, 0, 0});
        while (!q.isEmpty()) {
//            System.out.println("h = " + h);
            int[] point = q.poll();
            int z = point[0];
            int x = point[1];
            int y = point[2];

//            if (z == 4 && x == 4 && y == 4) {
//                return;
//            }
            for (int i = 0; i < 6; i++) {
                int newZ = z + ver[i];
                int newX = x + row[i];
                int newY = y + col[i];
//                System.out.println("newY = " + newY);
                if (newZ < 0 || newX < 0 || newY < 0 || newZ >= h || newX >= n || newY >= m) {
                    continue;
                }

                if (map[newZ][newX][newY] == 0) {
                    continue;
                }

                if (!v[newZ][newX][newY]) {
                    v[newZ][newX][newY] = true;
                    q.offer(new int[]{newZ, newX, newY});
                    result[newZ][newX][newY] = result[z][x][y] + 1;
                    if (newZ == 4 && newX == 4 && newY == 4) {
                        min = Math.min(min, result[4][4][4]);
                    }
                }
            }
//            if (result[4][4][4] == 12) {
//                System.out.println(12);
////                System.exit(0);
//            }
        }
    }

    public static void rotate(int height) {
        int[][][] newMap = new int[h][m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newMap[height][j][5 - i - 1] = map[height][i][j];
            }
        }

        map[height] = newMap[height].clone();
//        for (int k = 0; k < h; k++) {
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.print(map[k][i][j] + " ");
//                }
//                System.out.println();
//            }
//        }

//        System.out.println();
    }
}