package programmers;

/**
 * �   붕대 감기 250137
 * https://school.programmers.co.kr/learn/courses/30/lessons/250137
 */
public class Programmers250137 {
	
	public static void main(String[] args) {
		Solution250137 s = new Solution250137();
		int[] bandage = {
				//5, 1, 5
				//3, 2, 7
				//4, 2, 7
				1, 1, 1
				};
		int health = 
				//30;
				//20;
				5;
		int[][] attacks = {
				//{2, 10}, {9, 15}, {10, 5}, {11, 5}
				//{1, 15}, {5, 16}, {8, 6}
				//{1, 15}, {5, 16}, {8, 6}
				{1, 2} , {3, 2}
		};
		System.out.println(s.solution(bandage, health, attacks));
		
    }
	
	
	static class Solution250137 {
	    public int solution(int[] bandage, int health, int[][] attacks) {
 
	        int currentHealth = health;
	        int currentTime = 0;
	        int t = bandage[0];
	        int x = bandage[1];
	        int y = bandage[2];
	        
	        for(int i = 0; i < attacks.length; i++) {
	        	int attackTime = attacks[i][0];
	        	int attackDamage = attacks[i][1];
	        	
	        	int durringTime = attackTime - currentTime - 1 < 0 ? 0 : attackTime - currentTime - 1;
	        	
	        	int addHealth = durringTime * x;
	        	int plusHealth = (durringTime/t) * y;
	        	
	        	currentHealth += addHealth + plusHealth;
	        	
	        	if(currentHealth > health) {
	        		currentHealth = health;
	        	}
	        	
	        	currentHealth -= attackDamage;
	        	
	        	if(currentHealth <= 0) {
	        		return -1;
	        	}
	        	//System.out.println("attackTime: " + attackTime + ", currentHealth: " + currentHealth + ", addHealth: " + addHealth + ", plusHealth: " + plusHealth + ", durringTime: " + durringTime);
	        	currentTime = attackTime;   	
	        	
	        }
	        
	        
	        return currentHealth;
	    }
	}

}
