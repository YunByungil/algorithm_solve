import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, k, t, w;
    public static int[][] arr, tmp;
    public static int[] dp;
    public static int[] a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(final int[] o1, final int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int start = arr[0][1];
        int answer = 1;
        for (int i = 1; i < n; i++) {
            if (start <= arr[i][0]) {
//                System.out.println("start = " + start);
                answer++;
                start = arr[i][1];
            }
        }

        System.out.println(answer);

    }
}
