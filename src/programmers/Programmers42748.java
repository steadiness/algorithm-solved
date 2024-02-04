package programmers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * K번째수 42748
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */
public class Programmers42748 {

    public static void main(String[] args) {
    }

    static class Solution42748 {
        public int[] solution(int[] array, int[][] commands) {
            ArrayList<Integer> answerList = new ArrayList<>();


            for(int i = 0; i < commands.length; i++){
                //SUB 배열을 담을 List
                ArrayList<Integer> subList = new ArrayList<>();

                //짜르려는 배열을 담는다.
                for(int j = commands[i][0] - 1; j < commands[i][1]; j++){
                    subList.add(array[j]);
                }

                //정렬한다.
                Collections.sort(subList);

                //구하고자하는 인덱스의 값을 answerList에 담는다.
                answerList.add(subList.get(commands[i][2] - 1));
            }

            //List를 Array로 변형 후 반환.
            return answerList.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
