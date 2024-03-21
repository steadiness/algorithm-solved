package programmers;

import java.util.HashMap;

public class Programmers258712 {
	
	public static void main(String[] args) {
		
		Solution258712 s = new Solution258712();
		
		String[] frieds = {"a", "b", "c"};
		String[] gifts = {"a b", "b a", "c a", "a c", "a c", "c a"};
		
		System.out.println(s.solution(frieds, gifts));

		
    }
	
	
	static class Solution258712 {
		public int solution(String[] friends, String[] gifts) {
	        int answer = 0;
	        
	        int[][] giftMap = new int[friends.length][friends.length];
	        int[] giftScore = new int[friends.length];
	        
	        HashMap<String, Integer> friendsIndex = new HashMap<>();
	        
	        for(int i = 0; i < friends.length; i++) {
	        	friendsIndex.put(friends[i], i);
	        }
	        
	        for(int i = 0; i < gifts.length; i++) {
	        	String[] AB = gifts[i].split(" ");
	        	giftMap[friendsIndex.get(AB[0])][friendsIndex.get(AB[1])] += 1;
	        	giftScore[friendsIndex.get(AB[0])] += 1;
	        	giftScore[friendsIndex.get(AB[1])] -= 1;
	        }
	        
	        for(int i = 0; i < friends.length; i++) {
	        	int value = 0;
	        	for(int j = 0; j < friends.length; j++) {
	        		
	        		//본인 참조
	        		if(i == j) {
	        			continue;
	        		}
	        		
	        		//A가 선물을 많이 준 경우
	        		if(giftMap[i][j] > giftMap[j][i]) {
	        			value++;
	        		}
	        		// A,B 같은 경우
	        		else if(giftMap[i][j] == giftMap[j][i]) {
	        			//A의 선물 지수가 큰 경우
	        			if(giftScore[i] > giftScore[j]) {
	        				value++;
	        			}
	        		}	
	        	}
	        	if(answer < value) {
	        		answer = value;
	        	}
	        }
	        
	        return answer;
	    }
	}
	
}
