package programmers;

/**
 * 피로도 87946
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
public class Programmers87946 {

    public static void main(String[] args) {
    }

    static class Solution87946 {
        int max = 0;
        boolean visited[];

        public int solution(int k, int[][] dungeons) {
            int answer = -1;
            visited = new boolean[dungeons.length];

            for(int i = 0; i < dungeons.length; i++){
                visited[i] = true;

                if(dungeons[i][0] <= k){
                    max = max < 1 ? 1 : max;

                    DFS(k - dungeons[i][1], 1, dungeons);
                }
                visited[i] = false;
            }

            return max;
        }

        public void DFS(int k, int count, int[][] map){

            if(max < count)
                max = count;

            for(int i = 0; i < map.length; i++){

                if(visited[i] == false && k >= map[i][0]){
                    visited[i] = true;
                    DFS(k - map[i][1], count + 1, map);
                    visited[i] = false;
                }
            }

        }
    }
}
