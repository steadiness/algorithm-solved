package programmers;

import java.util.Arrays;

/**
 * 단독카메라 42884
 * https://school.programmers.co.kr/learn/courses/30/lessons/42884
 */
public class Programmers42884 {

    public static void main(String[] args) {
    }

    static class Solution42884 {
        public int solution(int[][] routes) {
            int answer = 1;

            //도로의 끝나는 지점을 기준으로 정렬합니다.
            Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

            int current_end = routes[0][1];

            for(int i = 0; i < routes.length; i++){

                //현재 끝나는 지점 보다 시작 지점이 빠른 경우 현재 끝나는 지점을 갱신합니다.
                if(routes[i][0] > current_end){
                    current_end = routes[i][1];
                    answer++;
                }
            }

            return answer;
        }
    }
}
