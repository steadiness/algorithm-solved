package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * 소수 찾기 42839
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 */
public class Programmers42839 {

    public static void main(String[] args) {
    }

    static class Solution42839{

        Set<Integer> numberSet = new HashSet<>();

        public int solution(String numbers) {
            int answer = 0;
            int n= numbers.length();

            char[] numberArray = numbers.toCharArray();
            char[] outputArray = new char[n];
            boolean[] visited = new boolean[n];

            for(int i = 1; i <= n; i++) {
                permutation(numberArray, outputArray, visited, 0, n, i);
            }

            return numberSet.size();
        }

        public void permutation(char[] number, char[] output, boolean[] visited, int depth, int n, int r){
            if(depth == r) {
                String temp = new String(output);

                if(temp.equals(new String("0")))
                    temp = temp.replaceFirst("^0+(?!$)", "");

                if(isPrime(Integer.parseInt(temp.trim())))
                    numberSet.add(Integer.parseInt(temp.trim()));
                return;
            }

            for(int i = 0; i < n; i++) {
                if (visited[i] != true) {
                    visited[i] = true;
                    output[depth] = number[i];
                    permutation(number, output, visited, depth + 1, n, r);
                    visited[i] = false;
                }
            }
        }

        public boolean isPrime(int num) {
            if (num == 0 || num == 1)
                return false;

            int lim = (int)Math.sqrt(num);

            for (int i = 2; i <= lim; i++)
                if (num % i == 0)
                    return false;

            return true;
        }
    }
}
