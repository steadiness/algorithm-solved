package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 최소 스패닝 트리 1197
 * www.acmicpc.net/problem/1197
 */
public class Baekjoon1197 {

    static ArrayList<Edge> edgeList;
    static int[] parent;

    public static int find(int a) {
        if(parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {

        int parent_a = find(a);
        int parent_b = find(b);

        parent[parent_b] = parent_a;
    }

    static boolean isCicle(int a, int b) {

        if(find(a) == find(b))
            return false;
        else
            return true;

    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parent = new int[v + 1];
        edgeList = new ArrayList<>();

        for(int i = 1; i <= v; i++)
            parent[i] = i;

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(a,b,c));
        }

        Collections.sort(edgeList);

        int answer = 0;

        for(int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);

            if(isCicle(edge.a, edge.b)) {
                answer += edge.c;
                union(edge.a, edge.b);
            }
        }

        System.out.println(answer);

    }

    static class Edge implements Comparable<Edge>{

        int a;
        int b;
        int c;

        Edge(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Edge edge) {
            if(this.c < edge.c)
                return -1;
            else if(this.c == edge.c)
                return 0;
            else
                return 1;
        }

    }

}


