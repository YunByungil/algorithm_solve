import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 나무의 수 n
        int m = Integer.parseInt(st.nextToken()); // 필요한 길이 m

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n]; // 나무의 높이를 담는 배열 arr
        long max = 0; // 절단기의 높이
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        long min = 0;
        long tree = 0;

        while (min < max) {
            tree = 0;
            long mid = (min + max) / 2;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] - mid > 0) {
                    tree += arr[i] - mid;
                }
            }

            if (tree < m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}