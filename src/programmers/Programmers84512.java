package programmers;

import java.util.ArrayList;

/**
 * 모음 사전
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */
public class Programmers84512 {

    public static void main(String[] args) {
    }

    static class Solution84512 {
        public int solution(String word) {
            String str = "AEIOU";
            int[] x = {781, 156, 31, 6, 1};

            int index;
            int result = word.length();

            for(int i = 0; i < word.length(); i++){
                index = str.indexOf(word.charAt(i));
                result+= x[i] * index;
            }
            return result;
        }
    }
}
