package programmers;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 가장 먼 노드 49189
 * https://school.programmers.co.kr/learn/courses/30/lessons/49189
 */
public class Programmers49189 {

    public static void main(String[] args) {

    }

    static class Solution49189 {
        public int solution(int n, int[][] edge) {

            List<List<Integer>> graph = new LinkedList<>();

            for(int i = 0; i < n + 1; i++) {
                graph.add(new LinkedList<>());
            }

            for(int[] e : edge) {
                int a = e[0];
                int b = e[1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean[] visited  = new boolean[n + 1];
            int[] distance = new int[n + 1];

            Queue<Integer> que = new LinkedList<>();
            que.add(1);
            visited[1] = true;
            while(!que.isEmpty()) {
                int cur = que.poll();

                for(int neighbor : graph.get(cur)) {
                    if(!visited[neighbor]) {
                        que.add(neighbor);
                        visited[neighbor] = true;
                        distance[neighbor] = distance[cur] + 1;
                    }
                }

            }

            int max = 0;
            for(int item : distance) {
                if(max < item)
                    max = item;
            }

            int answer = 0;
            for(int item : distance) {
                if(item == max)
                    answer++;
            }

            return answer;
        }
    }
}


