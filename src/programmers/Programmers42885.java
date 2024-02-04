package programmers;

import java.util.Arrays;

/**
 * 구명보트 42885
 * https://school.programmers.co.kr/learn/courses/30/lessons/42885
 */
public class Programmers42885 {

    public static void main(String[] args) {
    }

    static class Solution42885 {
        public int solution(int[] people, int limit) {
            int answer = 0;

            Arrays.sort(people);

            int min_index = 0;
            int max_index = people.length - 1;

            //가장 무거운 사람과 가장 가벼운 사람을 선택하여 함께 보낼 수 있는 경우 같이 보내고 아닌 경우 무거운 사람 혼자 보낸다.
            while(max_index >= min_index){
                if(people[max_index] + people[min_index] <= limit){
                    min_index++;
                    max_index--;
                    answer++;
                }else{
                    max_index--;
                    answer++;
                }
            }

            return answer;
        }
    }
}
