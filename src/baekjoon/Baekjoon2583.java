package baekjoon;

import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * 영역 구하기 2583
 * www.acmicpc.net/problem/2583
 */
public class Baekjoon2583 {
    static int M, N, K;
    static int[][] map = new int[100][100];
    static int[][] rec = new int[100][4];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0 ,-1, 0};

    public static int BFS(int r, int c) {

        int answer = 1;

        map[r][c] = 1;

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(r, c));

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            for(int i = 0; i < 4; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 1)
                    continue;

                answer++;
                map[nx][ny] = 1;
                queue.add(new Point(nx, ny));
            }
        }

        return answer;

    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //꼭지점 입력
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            rec[i][0] = x1;
            rec[i][1] = y1;
            rec[i][2] = x2;
            rec[i][3] = y2;
        }

        //BFS 체크
        for(int i = 0; i < K; i++) {
            for(int x = rec[i][0]; x < rec[i][2]; x++) {
                for(int y = rec[i][1]; y < rec[i][3]; y++) {
                    map[x][y] = 1;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    list.add(BFS(i, j));
                }
            }
        }

        list.sort(null);

        System.out.println(list.size());
        for(int a : list)
            System.out.print(a + " ");

    }

}
