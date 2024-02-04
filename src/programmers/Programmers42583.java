package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 다리를 지나는 트럭 42583
 * https://school.programmers.co.kr/learn/courses/30/lessons/42583
 */
public class Programmers42583 {

    public static void main(String[] args) {
    }

    static class Solution42583{
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;

            Queue<Integer> que = new LinkedList<>();
            int current_weight = 0;

            for(int item : truck_weights) {

                while(true) {
                    if(que.isEmpty()) {
                        que.add(item);
                        current_weight = item;
                        answer++;
                        break;
                    }
                    else if(que.size() == bridge_length) {
                        current_weight -= que.poll();
                    }else {
                        if(current_weight + item <= weight) {
                            que.add(item);
                            current_weight += item;
                            answer++;
                            break;
                        }else {
                            que.add(0);
                            answer++;
                        }
                    }
                }
            }

            return answer + bridge_length;

        }
    }
}
