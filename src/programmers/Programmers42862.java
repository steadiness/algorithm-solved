package programmers;

import java.util.Arrays;

/**
 * 체육복 42862
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 */
public class Programmers42862 {

    public static void main(String[] args) {
    }

    static class Solution42862{
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;

            int[] totalArr = new int[n];

            Arrays.fill(totalArr, 1);

            for(int item : reserve)
                totalArr[item - 1] = 2;

            for(int item : lost)
                totalArr[item - 1]  = totalArr[item - 1] == 2 ? 1 : 0;


            for(int i = 0; i < totalArr.length; i++){

                if(totalArr[i] == 1){
                    answer++;
                    continue;
                }

                if(totalArr[i] == 2){
                    if(i > 0 && totalArr[i - 1] == 0){
                        answer += 2;
                    }else if(i < n - 1 && totalArr[i + 1] == 0){
                        totalArr[i + 1] = 1;
                        answer++;
                    }else
                        answer++;
                }
            }

            return answer;
        }
    }
}
