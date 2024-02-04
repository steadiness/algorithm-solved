package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1로 만들기 1463
 * www.acmicpc.net/problem/1463
 */
public class Baekjoon1463 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[x + 1];
        arr[1] = 0;

        for(int i = 2; i <= x; i++) {
            arr[i] = arr[i-1] + 1;

            if(i % 2 == 0){
                arr[i] = Math.min(arr[i], arr[i/2] + 1);
            }
            if(i % 3 == 0){
                arr[i] = Math.min(arr[i], arr[i/3] + 1);
            }
        }

        System.out.println(arr[x]);
    }

}
