package programmers;

import java.util.Stack;

/**
 * 올바른 괄호 12909
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
public class Programmers12909 {

    public static void main(String[] args) {
    }

    static class Solution12909 {
        boolean solution(String s) {
            boolean answer = true;

            Stack<Character> stack = new Stack<>();

            for(char item : s.toCharArray()){
                if(item == '(')
                    stack.push(item);
                else{
                    if(stack.isEmpty())
                        return false;

                    if(stack.pop() == ')')
                        return false;
                }

            }

            if(!stack.isEmpty())
                return false;

            return answer;
        }
    }
}
