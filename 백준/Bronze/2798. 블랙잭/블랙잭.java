import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static int[] arr;

    public static int[] num;
    public static boolean[] visit;

    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visit = new boolean[n];
        num = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        combination(0, 0);

        System.out.println(max);
    }

    public static void combination(int start, int depth) {
        if (depth == 3) {
            int result = 0;
            for (int i = 0; i < num.length; i++) {
                result += num[i];
            }
            if (result <= m) {
                max = Math.max(max, result);
            }
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                num[depth] = arr[i];
                combination(i, depth + 1);
                visit[i] = false;
            }
        }
    }
}
