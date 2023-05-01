import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] arr = new int[k];
        int nowScore = 0;
        // 상위 k번째 이내이면 해당 가수의 점수를 명예의 전당이라는 목록에 올려 기념한다.
        
        Arrays.fill(arr, 2001);
        
        if (score.length <= k) {
            arr = new int[score.length];
            Arrays.fill(arr, 2001);
            for (int i = 0; i < score.length; i++) {
                
                arr[i] = score[i];
                
                Arrays.sort(arr);
                answer[i] = arr[0];
            }
            return answer;
        }
        
        for (int i = 0 ; i < k; i++) {
            arr[i] = score[i];
            Arrays.sort(arr);
            answer[i] = arr[0];
        }
        
        
        
        
        for (int i = k; i < score.length; i++) {
            
            if (arr[0] < score[i]) {
                
                arr[0] = score[i];
                Arrays.sort(arr);
                answer[i] = arr[0];
                
                
            } else {
                answer[i] = arr[0];
                
            }
        }
        
        
        
        
        
        return answer;
    }
}