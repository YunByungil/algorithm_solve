import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(binarySearch(arr, 0, n -1, Integer.parseInt(st.nextToken()))).append(" ");
        }

        System.out.println(sb);

    }

    public static int binarySearch(int[] arr, int start, int end, int target) {
        int mid = (start + end) / 2;
        while (start <= end) {

            if (arr[mid] == target) {
                return 1;
            } else if (arr[mid] <= target) {
                start = mid + 1;
                mid = (start + end) / 2;
            } else {
                end = mid - 1;
                mid = (start + end) / 2;
            }
        }
        return 0;
    }
}