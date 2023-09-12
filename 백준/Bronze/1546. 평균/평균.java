import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        float[] result = new float[n];
        float sum = 0f;
        float max = 0f;
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
             score[i] = Integer.parseInt(st.nextToken());
             max = Math.max(max, score[i]);
        }

        for (int i = 0; i < n; i++) {
            result[i] = (score[i] / max) * 100;
        }

        for (float v : result) {
            sum += v;
        }
        float avg = sum / n;
        System.out.println(avg);
    }
}