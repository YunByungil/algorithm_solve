import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, v;
    public static int count = 1;
    public static boolean[] visit;
    public static boolean[][] arr;
    public static int[] result;
    public static StringBuilder sb = new StringBuilder();
    public static StringBuilder sb2 = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 정점 n
        m = Integer.parseInt(st.nextToken()); // 간선 m
        v = Integer.parseInt(st.nextToken()); // 시작 정점 v

        visit = new boolean[n + 1];
        arr = new boolean[n + 1][n + 1];
        result = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = true;
            arr[b][a] = true;
        }

        dfs(v);
        System.out.println(sb);

        count = 1;
        result = new int[n + 1];
        bfs(v);
        System.out.println(sb2);

    }

    public static void dfs(int start) {
        sb.append(start).append(" ");

        visit[start] = true;
        result[start] = count++;

        for (int i = 1; i <= n; i++) {
            if (!visit[i] && arr[start][i]) {
                dfs(i);
            }
        }
    }


    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        result[start] = count++;
        sb2.append(start).append(" ");
        while (!q.isEmpty()) {
            int value = q.poll();
            for (int i = 1; i <= n; i++) {
                if (arr[value][i]) {
                    if (result[i] != 0) {
                        continue;
                    }
                    sb2.append(i).append(" ");
                    result[i] = count++;
                    q.offer(i);
                }
            }
        }
    }
}