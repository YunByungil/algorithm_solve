import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n + 1];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            map.put(name, i);
            arr[i] = name;
        }

        for (int i = 1; i <= m; i++) {
            String input = br.readLine();
            if (isNum(input)) {
                sb.append(arr[Integer.parseInt(input)]).append("\n");
            } else {
                sb.append(map.get(input)).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean isNum(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}