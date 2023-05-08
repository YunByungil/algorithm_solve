import java.util.*;
import java.io.*;

public class Main {
    public static int t;
    public static int r, c; // r: 미로 행의 개수, c: 열의 개수
    public static int answer = 0;
    public static String[][] arr;
    public static boolean[][] visit;
    public static int[][] result;
    public static int[] row = {-1, 1, 0, 0};
    public static int[] col = {0, 0, 1, -1};
    public static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            arr = new String[c][r];
            visit = new boolean[c][r];
            result = new int[c][r];


            for (int i = 0; i < c; i++) {
                String str = br.readLine();
                for (int j = 0; j < str.length(); j++) {
                    arr[i][j] = String.valueOf(str.charAt(j));
                    if (arr[i][j].equals("*")) {
                        q.offer(new int[]{i, j});
                        visit[i][j] = true;
                    }
                }
            }
            for (int i = 0; i < c; i++) {
                for (int j = 0; j < r; j++) {
                    if (arr[i][j].equals("@")) {
                        q.offer(new int[]{i, j});
                        result[i][j] = 1;
                        visit[i][j] = true;
                    }
                }
            }


            if (bfs()) {
                System.out.println(answer);
            } else {
                System.out.println("IMPOSSIBLE");
            }

//            for (int i = 0; i < c; i++) {
//                for (int j = 0; j < r; j++) {
//                    System.out.print(arr[i][j] + " ");
//                }
//                System.out.println();
//            }
        }
    }

    public static boolean bfs() {
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowY = nowLocation[0];
            int nowX = nowLocation[1];

            for (int i = 0; i < 4; i++) {
                int newY = nowY + row[i];
                int newX = nowX + col[i];
                if (arr[nowY][nowX].equals("@")) {
                    if (newY < 0 || newY >= c || newX < 0 || newX >= r) {
                        answer = result[nowY][nowX];
                        return true;
                    }
                }


                if (newY < 0 || newY >= c || newX < 0 || newX >= r) {
                    continue;
                }

                if (!visit[newY][newX] && arr[newY][newX].equals(".")
                        && arr[nowY][nowX].equals("*")) {
                    q.offer(new int[]{newY, newX});
                    visit[newY][newX] = true;
                    arr[newY][newX] = "*";
                }

                if (!visit[newY][newX] && arr[newY][newX].equals(".")
                        && arr[nowY][nowX].equals("@")) {
                    q.offer(new int[]{newY, newX});
                    visit[newY][newX] = true;
                    arr[newY][newX] = "@";
                    result[newY][newX] = result[nowY][nowX] + 1;
                    answer = result[newY][newX];
                }
            }
        }


        return false;
    }
}
