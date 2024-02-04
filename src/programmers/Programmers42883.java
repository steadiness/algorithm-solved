package programmers;

/**
 * 큰 수 만들기 42883
 * https://school.programmers.co.kr/learn/courses/30/lessons/42883
 */
public class Programmers42883 {

    public static void main(String[] args) {
    }

    static class Solution42883 {
        public String solution(String number, int k) {
            StringBuilder answer = new StringBuilder();
            int start = 0;
            int max = 0;

            for(int i = 0; i < number.length() - k; i++){
                max  = 0;
                for(int j = start; j <= k + i; j++){
                    if(max < number.charAt(j) - '0'){
                        max = number.charAt(j) - '0';
                        start = j + 1;
                    }
                }
                answer.append(max);
            }

            return answer.toString();
        }
    }
}
