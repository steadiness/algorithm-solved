package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 그림 1926
 * www.acmicpc.net/problem/1926
 */
public class Baekjoon1926 {
    static int n, m, answer = 0, temp_square = 0;
    static int[][] map;
    static int[][] visit;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void DFS(int idx, int jdx) {

        if(answer < temp_square)
            answer = temp_square;

        for(int i = 0; i < 4; i++) {

            int nx = idx + dx[i];
            int ny = jdx + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m || visit[nx][ny] == 1 || map[nx][ny] == 0)
                continue;

            temp_square++;
            visit[nx][ny] = 1;
            DFS(nx, ny);

        }

    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {

                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int picture_cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(visit[i][j] == 0 && map[i][j] == 1) {
                    visit[i][j] = 1;
                    temp_square = 1;
                    DFS(i,j);
                    picture_cnt++;
                }
            }
        }

        System.out.println(picture_cnt);
        System.out.println(answer);

    }

}
