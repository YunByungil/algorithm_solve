import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n; // 참가하는 학생 수
    public static int k; // 한 방에 배정할 수 있는 최대 인원 수
    public static int s; // 학생의 성별 => 여자 0, 남자 1
    public static int y; // 학생의 학년
    public static int result; // 필요한 방의 개수
    public static int[][] arr; // 학생 학년, 성별을 담는 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[7][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            arr[y][s]++;

        }


        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (arr[i][j] > 0) {
                    if (arr[i][j] >= k) {
                        result += arr[i][j] / k;
                        if (arr[i][j] % k >= 1) {
                            result += arr[i][j] % k;
                        }
                    } else {
                        result++;
                    }
                }
            }
        }

        System.out.println(result);

    }
}