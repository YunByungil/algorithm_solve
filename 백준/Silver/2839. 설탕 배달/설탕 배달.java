import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static final int FIVE_KG = 5;
    public static final int THREE_KG = 3;

    public static int count = 1;

    public static int remainder = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sugarBag = Integer.parseInt(br.readLine());
        getSugarBagCount(sugarBag);
    }

    // 내가 입력한 Kg이 5로 다 나누어 질 때, 다 나누어지지 않을 때 2가지 경우의 수로 시작한다.
    public static void getSugarBagCount(int sugarBag) {
        if (sugarBag % FIVE_KG == 0) {
            getFiveKgBagCount(sugarBag);
        } else if (sugarBag % FIVE_KG != 0) {
            checkMaxFiveKgBagCount(sugarBag);
        }
    }

    // 내가 입력한 Kg이 5로 다 나누어 질 때 바로 출력
    public static void getFiveKgBagCount(int sugarBag) {
        System.out.println(sugarBag / FIVE_KG);
    }

    // 내가 입력한 Kg이 5로 다 나누어지지 않을 때 계산
    // 5로 최대한 나누었을 때, 하나씩 나누었을 때를 비교해서 계산

    public static void checkMaxFiveKgBagCount(int sugarBag) {
        int mok = sugarBag / FIVE_KG;
        remainder = sugarBag % FIVE_KG;

        if (remainder % 3 == 0) {
            System.out.println(mok + (remainder / THREE_KG));
        } else if (remainder % 3 != 0) {
            checkFiveKgBagCount(sugarBag);
        }

    }
    public static void checkFiveKgBagCount(int sugarBag) {
        int result = 0;
        int lastResult = 0;
        while (true) {
            result = sugarBag - (FIVE_KG * count);
            if (result < 0) {
                break;
            }
            if (result % 3 == 0) { // 5로 하나씩 나누고 그 값이 3으로 나누어 떨어질 때
                lastResult = count + (result / THREE_KG);
            }
            count++;
        }
        if (lastResult == 0) {
            checkThreeKgBagCount(sugarBag);
        } else if (lastResult != 0) {
            System.out.println(lastResult);
        }
    }

    // 3으로만 나누어 떨어질 수 있는지 확인
    public static void checkThreeKgBagCount(int sugarBag) {
        if (sugarBag % 3 == 0) { // 3으로 나누어 떨어짐
            getOnlyThreeKgBagCount(sugarBag);
        } else if (sugarBag % 3 != 0) { // 3으로도 아예 안 나누어 떨어짐
            System.out.println(-1);
        }
    }

    public static void getOnlyThreeKgBagCount(int sugarBag) {
        System.out.println(sugarBag / THREE_KG);
    }
}