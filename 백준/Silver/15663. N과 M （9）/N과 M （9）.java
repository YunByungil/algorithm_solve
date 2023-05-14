import java.util.*;
import java.io.*;

class Main {
    static int N, M, check;
    static int[] arr;
    static int[] numArr;
    static boolean[] visit;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visit = new boolean[N];
        numArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numArr);
        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == M) { //원하는 만큼 뽑았으면 탈출
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");

            }
            sb.append("\n");
            return;
        }
            for (int i = 0; i < N; i++) {
                if (!visit[i] && arr[depth] != numArr[i] ) {
                    visit[i] = true;
                    arr[depth] = numArr[i];
//                    System.out.println("check = " + check);
                    dfs(depth + 1);
                    visit[i] = false;
                }
            }
            arr[depth] = 0;
        }
}