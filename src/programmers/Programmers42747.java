package programmers;

import java.util.Arrays;

/**
 * H-INDEX 42747
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */
public class Programmers42747 {

    public static void main(String[] args) {
    }

    static class Solution42747 {
        public int solution(int[] citations) {
            int answer = 0;

            Arrays.sort(citations);

            for (int i = 0; i < citations.length; i++)
                if (citations[i] >= citations.length - i) {
                    answer = citations.length - i;
                    break;
                }

            return answer;
        }
    }
}
