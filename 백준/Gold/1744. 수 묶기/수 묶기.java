import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int sum;
    public static int one;
    public static PriorityQueue<Integer> positiveNumber = new PriorityQueue<>(Comparator.reverseOrder());
    public static PriorityQueue<Integer> negativeNumber = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number <= 0) {
                negativeNumber.add(number);
            } else if (number > 1) {
                positiveNumber.add(number);
            } else if (number == 1) {
                one++;
            }
        }


//        while (!positiveNumber.isEmpty()) {
//            System.out.println("positiveNumber = " + positiveNumber.poll());
//        }
//        while (!negativeNumber.isEmpty()) {
//            System.out.println("positiveNumber = " + negativeNumber.poll());
//        }
        getMax(positiveNumber);
        getMax(negativeNumber);
        sum += one;

        System.out.println(sum);
    }

    public static void getMax(PriorityQueue<Integer> pq) {
        while (pq.size() > 1) {
            sum += (pq.poll() * pq.poll());
        }

        if (pq.size() == 1) {
            sum += pq.poll();
        }
    }
}