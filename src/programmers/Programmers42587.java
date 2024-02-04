package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 프린터 42587
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 */
public class Programmers42587 {

    public static void main(String[] args) {
    }

    static class Solution42587 {
        public int solution(int[] priorities, int location) {

            int answer = 1;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for(int item: priorities)
                pq.add(item);

            while(!pq.isEmpty()){
                for(int i = 0 ; i < priorities.length; i++){
                    if(priorities[i] == pq.peek()){
                        if(i == location)
                            return answer;
                        pq.poll();
                        answer++;

                    }
                }
            }
            return answer;
        }
    }
}
