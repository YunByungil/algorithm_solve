import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        int idx = 0;
        int[] arr = new int[n + 1];
        int divisor = 2;
        
        while (n > 1) {
            if (n % divisor == 0) {
                arr[divisor] = divisor;
                n /= divisor;
            } else {
                divisor++;
            }
        }
        
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                size++;
            }
        }
        
        answer = new int[size];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                answer[idx++] = arr[i];
            }
        }
        
        return answer;
    }
}