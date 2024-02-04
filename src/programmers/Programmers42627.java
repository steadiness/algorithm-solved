package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 디스크 컨트롤러
 * https://school.programmers.co.kr/learn/courses/30/lessons/42627
 */
public class Programmers42627 {

    public static void main(String[] args) {
    }

    static class Solution42627 {

        public int solution(int[][] jobs) {

            int answer = 0;

            int cnt = 0;
            int current_index = 0;
            int current_end = 0;

            Arrays.sort(jobs, (obj1, obj2) -> obj1[0] - obj2[0]);

            PriorityQueue<int[]> pq = new PriorityQueue<>((obj1, obj2) -> obj1[1] - obj2[1]);

            while(cnt < jobs.length){

                while(current_index < jobs.length && jobs[current_index][0] <= current_end){
                    pq.add(jobs[current_index++]);
                }

                if(pq.isEmpty()){
                    current_end = jobs[current_index][0];
                }
                else{
                    int[] temp = pq.poll();
                    answer += temp[1] + current_end - temp[0];
                    current_end += temp[1];
                    cnt++;
                }

            }

            return (int) Math.floor(answer / jobs.length);
        }
    }
}
