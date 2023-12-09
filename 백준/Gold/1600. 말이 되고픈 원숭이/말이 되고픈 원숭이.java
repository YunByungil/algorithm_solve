import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int k, w, h;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] jumpX = {-1, -1, -2, -2, +1, +1, +2, +2};
    public static int[] jumpY = {-2, +2, -1, +1, -2, +2, -1, +1};
    public static int[][] arr;
    public static int[][] result;
    public static boolean[][][]visit;
    public static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][w];
        result = new int[h][w];
        visit = new boolean[h][w][k + 1];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                result[i][j] = num;
            }
        }

        if (h == 1 && w == 1) {
            System.out.println(0);
            return;
        }
        int answer = bfs();

        System.out.println(answer);

    }

    public static int bfs() {
        q.offer(new int[]{0, 0, 0});
        visit[0][0][0] = true;
//        visit[0][0][1] = true;
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowX = nowLocation[0];
            int nowY = nowLocation[1];
            int jumped = nowLocation[2];

            for (int i = 0; i < 4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];

                if (newX < 0 || newX >= h || newY < 0 || newY >= w) {
                    continue;
                }
                if (arr[newX][newY] == 1) {
                    continue;
                }

                if (arr[newX][newY] == 0) {
                    if (!visit[newX][newY][jumped]) {
                        visit[newX][newY][jumped] = true;
                        q.offer(new int[]{newX, newY, jumped});
                        result[newX][newY] = result[nowX][nowY] + 1;
                    }
                }

                if (newX == h - 1 && newY == w - 1) {
                    return result[newX][newY];
                }
            }

            for (int i = 0; i < 8; i++) {
                int newX = nowX + jumpX[i];
                int newY = nowY + jumpY[i];

                if (newX < 0 || newX >= h || newY < 0 || newY >= w) {
                    continue;
                }

                if (arr[newX][newY] == 1) {
                    continue;
                }

                if (arr[newX][newY] == 0) {
                    if (jumped < k && !visit[newX][newY][jumped + 1]) {
                        q.offer(new int[]{newX, newY, jumped + 1});
                        visit[newX][newY][jumped + 1] = true;
                        result[newX][newY] = result[nowX][nowY] + 1;

                        if (newX == h - 1 && newY == w - 1) {
                            return result[newX][newY];
                        }
                    }
                }
            }
        }
        return -1;
    }
}
