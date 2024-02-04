package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 전력망을 둘로 나누기 86971
 * https://school.programmers.co.kr/learn/courses/30/lessons/86971
 */
public class Programmers86971 {

    public static void main(String[] args) {
    }

    static class Solution86971 {

        boolean[][] MAP;

        public int solution(int n, int[][] wires) {
            int answer = 987654321;

            MAP = new boolean[n + 1][n + 1];

            for(int[] item : wires) {
                MAP[item[0]][item[1]] = true;
                MAP[item[1]][item[0]] = true;
            }

            for (int i = 0; i < wires.length; i++) {

                MAP[wires[i][0]][wires[i][1]] = false;
                MAP[wires[i][1]][wires[i][0]] = false;

                answer = Math.min(answer, BFS(n, wires[i][0]));

                MAP[wires[i][0]][wires[i][1]] = true;
                MAP[wires[i][1]][wires[i][0]] = true;

            }

            return answer;
        }

        public int BFS(int n, int start) {

            boolean[] visited = new boolean[n+1];
            int cnt = 1;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);

            while(!queue.isEmpty()) {
                int pos = queue.poll();
                visited[pos] = true;

                for(int i = 1; i <= n; i++) {
                    if(visited[i] == false && MAP[pos][i] == true) {
                        queue.add(i);
                        cnt++;
                    }
                }
            }
            return (int)Math.abs(n - (cnt * 2));
        }

    }
}
