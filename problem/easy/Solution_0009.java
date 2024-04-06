package problem.easy;

import java.util.*;
import java.io.*;

/**
9. Palindrome Number
Solved
Easy
Topics
Companies
Hint
Given an integer x, return true if x is a 
palindrome
, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1
 

Follow up: Could you solve it without converting the integer to a string?
 */

public class Solution_0009 {
	public boolean isPalindrome(int x) {
		
		if(x < 0) { // is Number nagative, It can't be palindrome
			return false;
		}
		
		String str = Integer.toString(x);
		char[] chStr = str.toCharArray();
		
		for(int i = 0, j = chStr.length - 1; i < j; i++,j--) {
			if(chStr[i] != chStr[j]) // if It's not same in every letters,
				return false;
		}
		
		// if It's same in every letters.
		return true;
	}
}
