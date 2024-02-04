package programmers;

/**
 * 도둑질 42987
 * https://school.programmers.co.kr/learn/courses/30/lessons/42897
 */
public class Programmers42897 {

    public static void main(String[] args) {
    }

    static class Solution42897 {
        public int solution(int[] money) {
            int n = money.length;
            int[] dp1 = new int[n]; //첫 번째 집을 털었을 때
            int[] dp2 = new int[n]; //첫 번째 집을 털지 않았을 때

            dp1[0] = money[0];
            dp1[1] = money[0];
            for (int i = 2; i < n-1; i++) {
                dp1[i] = Math.max(dp1[i-1], dp1[i-2]+money[i]);
            }

            // 첫 번째 집을 털지 않고 시작하는 경우
            dp2[0] = 0; // 첫 번째 집을 털지 않으므로 첫 번째 집의 돈은 없음
            dp2[1] = money[1];
            for (int i = 2; i < n; i++) {
                dp2[i] = Math.max(dp2[i-1], dp2[i-2]+money[i]);
            }

            return Math.max(dp1[n-2], dp2[n-1]);
        }
    }
}
