class Solution {
    private static int answer = 0;

    public static int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }

    private static void dfs(int index, int sum, int[] numbers, int target){
        if(index == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }

        dfs(index + 1, sum + numbers[index], numbers, target);
        dfs(index + 1, sum - numbers[index], numbers, target);
    }
}
