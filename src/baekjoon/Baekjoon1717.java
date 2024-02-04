package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 집합의 표현 1717
 * www.acmicpc.net/problem/1717
 */
public class Baekjoon1717 {

    static int[] parent;

    public static void union(int a, int b) {

        int parent_a = find(a);
        int parent_b = find(b);

        parent[parent_b] = parent_a;
    }

    public static int find(int a) {

        if(parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        for(int i = 0; i <= n; i++)
            parent[i] = i;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(c == 0)
                union(a, b);
            else {
                if(find(a) == find(b))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
}
