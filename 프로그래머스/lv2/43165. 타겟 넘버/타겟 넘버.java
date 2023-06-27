class Solution {
    public static int[] cal;
    public static int n, result;
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        cal = new int[2];
        cal[0] = n;
        cal[1] = n;
        int answer = 0;
        dfs(0, 0, target, numbers);
        answer = result;
        return answer;
    }
    
    public static void dfs(int sum, int depth, int target, int[] numbers) {
        
        if (depth == n) {
            
            if (target == sum) {
                result++;
            }
            return;
        }
        
        for (int i = 0; i < 2; i++) {
            
            if (cal[i] > 0) {
                
                cal[i]--;
                
                if (i == 0) {
                    dfs(sum + numbers[depth], depth + 1, target, numbers);
                } else if (i == 1) {
                    dfs(sum - numbers[depth], depth + 1, target, numbers);
                }
                
                cal[i]++;
            }
            
        }
    }
}