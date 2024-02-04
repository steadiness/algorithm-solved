package programmers;

import java.util.Arrays;

/**
 * 가장 큰 수 42746
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */
public class Programmers42746 {

    public static void main(String[] args) {
    }

    static class Solution42746 {
        public String solution(int[] numbers) {
            String answer = "";

            answer = Arrays.stream(numbers)
                    .mapToObj(String::valueOf)
                    .sorted(((s1, s2) -> (s2+s1).compareTo(s1 + s2)))
                    .reduce("", (s1, s2) ->  s1.equals("0") && s2.equals("0") ? "0" : s1 + s2);

            return answer;
        }
    }
}
