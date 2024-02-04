package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 이중 우선 순위 큐 42628
 * https://school.programmers.co.kr/learn/courses/30/lessons/42628
 */
public class Programmers42628 {

    public static void main(String[] args) {
    }

    static class Solution42628 {
        public int[] solution(String[] operations) {
            int[] answer = new int[2];

            PriorityQueue<Integer> max_queue = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> min_queue = new PriorityQueue<>();

            ArrayList<Integer> answerList = new ArrayList<>();

            for(String item : operations){

                if(item.contains("I")){
                    int temp = Integer.parseInt(item.substring(2, item.length()));
                    max_queue.add(temp);
                    min_queue.add(temp);
                    continue;
                }else if(item.equals("D 1")){
                    if(max_queue.isEmpty())
                        continue;

                    min_queue.remove(max_queue.poll());

                }else if(item.equals("D -1")){
                    if(min_queue.isEmpty())
                        continue;

                    max_queue.remove(min_queue.poll());
                }

            }

            if(max_queue.isEmpty() || min_queue.isEmpty()){
                answer[0] = 0;
                answer[1] = 0;
                return answer;
            }

            if(min_queue.peek() > max_queue.peek()){
                answer[0] = 0;
                answer[1] = 0;
                return answer;
            }
            if(min_queue.peek() == max_queue.peek()){
                answer[0] = min_queue.peek();
                answer[1] = min_queue.peek();
                return answer;
            }
            answer[0] = max_queue.peek();
            answer[1] = min_queue.peek();


            return answer;
        }
    }
}
