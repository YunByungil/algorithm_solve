import java.util.*;
import java.io.*;

public class Main {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        Map<Long, Long> map = new HashMap<>();
        for (long i : arr) {
            map.put(i, map.getOrDefault(i, 0L) + 1);
        }

        long first = 0;
        long num = 0;
        long count = 0;
        for (Long i : map.keySet()) {
            if (first == 0) {
                first = -1;
                count = map.get(i);
                num = i;
                continue;
            }
            if (count < map.get(i)) {
                count = map.get(i);
                num = i;
            } else if (count == map.get(i)) {
                num = Math.min(num, i);
            }
        }

        System.out.println(num);
    }
}
