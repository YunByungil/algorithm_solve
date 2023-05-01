import java.io.*;
import java.util.*;

public class Main {
    public static Deque<Integer> q = new LinkedList<>();
    public static Deque<Integer> q2 = new LinkedList<>();
    public static int n; // 큐의 크기 n
    public static int m; // 뽑아내려고 하는 수의 개수 m
    public static int location; // 뽑아내려고 하는 수의 위치가 순서대로 주어짐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            q.offer(i);
            q2.offer(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int findNum = Integer.parseInt(st.nextToken());
            int leftResult = getLeftMin(findNum);
            int rightResult = getRightMin(findNum);

            if (leftResult <= rightResult) {
                answer += leftResult;
            } else {
                answer += rightResult;
            }
        }
        
        System.out.println(answer);
    }

    public static int getLeftMin(int num) {
        int c1 = 0;
        while (true) {

            if (q.peek() == num) {
                q.pop();
                break;
            }

            q.offerLast(q.pollFirst()); // 왼쪽으로 이동
            c1++;
        }

        return c1;
    }

    public static int getRightMin(int num) {
        int c1 = 0;
        while (true) {

            if (q2.peek() == num) {
                q2.pop();
                break;
            }

            q2.offerFirst(q2.pollLast()); // 왼쪽으로 이동
            c1++;
        }

        return c1;
    }
}
