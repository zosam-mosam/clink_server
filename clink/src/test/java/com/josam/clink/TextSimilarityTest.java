package com.josam.clink;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TextSimilarityTest {

	@Test
	public void TextSimilarity() {
		double test = similarity("test1234","1234test");
		System.out.println(test);
	}
	
	private double similarity(String s1, String s2) {
	    String longer = s1, shorter = s2;
	    
	    if (s1.length() < s2.length()) {
	        longer = s2; 
	        shorter = s1;
	    }
	    
	    int longerLength = longer.length();
	    if (longerLength == 0) return 1.0;
	    return (longerLength - editDistance(longer, shorter)) / (double) longerLength;
	}
	
	private int editDistance(String s1, String s2) {
	    int[] costs = new int[s2.length() + 1];
	    
	    for (int i = 0; i <= s1.length(); i++) {
	        int lastValue = i;
	        for (int j = 0; j <= s2.length(); j++) {
	            if (i == 0) {
	                costs[j] = j;
	            } else {
	                if (j > 0) {
	                    int newValue = costs[j - 1];
	                    
	                    if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
	                        newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
	                    }
	                    
	                    costs[j - 1] = lastValue;
	                    lastValue = newValue;
	                }
	            }
	        }
	        
	        if (i > 0) {costs[s2.length()] = lastValue;
	        System.out.println(costs[s2.length()]);
	        }
	    }
	    return costs[s2.length()];
	}
}
