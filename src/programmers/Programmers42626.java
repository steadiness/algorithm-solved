package programmers;

import java.util.PriorityQueue;

/**
 * 더 맵게 42626
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
public class Programmers42626 {
    public static void main(String[] args) {
    }

    static class Solution42626 {
        public int solution(int[] scoville, int K) {
            int answer = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int item : scoville)
                pq.add(item);

            while(!pq.isEmpty()){
                int min = (int)pq.poll();

                if(min >= K)
                    break;
                else if(pq.isEmpty()){
                    answer = -1;
                }
                else{
                    pq.add(min + ((int)pq.poll() * 2));
                    answer++;
                }
            }

            return answer;
        }
    }
}
