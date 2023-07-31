import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int m, n, count;
    public static int[][] arr, sorted;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        sorted = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sorted[i][j] = arr[i][j];
            }
            Arrays.sort(sorted[i]);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = binarySearch(i, arr[i][j]);
            }
        }

        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                if (Arrays.equals(arr[i], arr[j])) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
    
    public static int binarySearch(int i, int num) {
        int start = 0;
        int end = n;

        while (start < end) {
            int mid = (start + end) / 2;

            if (sorted[i][mid] == num) {
                end = mid;
            } else if (sorted[i][mid] > num) {
                end = mid;
            } else if (sorted[i][mid] < num) {
                start = mid + 1;
            }
        }
        
        return start;
    } 
}