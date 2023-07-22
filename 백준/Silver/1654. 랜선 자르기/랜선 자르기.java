import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); // 내가 갖고있는 랜선 k개
        int n = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수 n개

        int[] arr = new int[k]; // k개를 담는 배열
        long max = 0; // k개의 랜선 중 가장 긴 랜선
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        max++;

        long start = 0;
        long end = max;

        while (start < end) {
            long count = 0;
            long mid = (start + end) / 2;
            
            for (int i = 0; i < k; i++) {
                count += arr[i] / mid;
            }

            if (count < n) {
                end = mid;
            } else if (count == n) {
                start = mid + 1;
            } else if (count > n) {
                start = mid + 1;
            }
        }

        System.out.println(start - 1 );
    }
}