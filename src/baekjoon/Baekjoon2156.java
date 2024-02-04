package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 포도주 시식 2156
 * www.acmicpc.net/problem/2156
 */
public class Baekjoon2156 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            if(i == 1) {
                dp[1] = arr[1];
            }else if(i == 2) {
                dp[i] = arr[1] + arr[2];
            }else {
                dp[i] = Math.max(dp[i-1],Math.max(arr[i] + dp[i-2], arr[i] + arr[i-1] + dp[i-3]));
            }
        }

        System.out.println(dp[n]);
    }

}
