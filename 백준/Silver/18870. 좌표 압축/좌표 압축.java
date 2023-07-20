import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sorted = new int[n];
        int rank = 0;
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
             arr[i] = Integer.parseInt(st.nextToken());
             sorted[i] = arr[i];
        }

        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : sorted) {
            if (!map.containsKey(i)) {
                map.put(i, rank);
                rank++;
            }
        }

        for (int i : arr) {
            sb.append(map.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}