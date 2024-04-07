package problem.easy;

import java.util.*;
import java.io.*;

/**
20. Valid Parentheses
Easy
Topics
Companies
Hint
Given a string s containing just the characters 
'(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */

public class Solution_0020 {
	public boolean isValid(String s) {
		
		// keep containing until To match close bracket is reaching.
		String containOpenBrackets = "";
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			// if open bracket char, contain to value "containOpenBrackets".
			if((ch == '(' || ch == '{' || ch == '[')) 
				containOpenBrackets += ch;
			
			else { // if close bracket char, checking length of contain.. and last char of contain...
				
				// if there's nothing in containOpen... String is not valid.
				if(containOpenBrackets.isEmpty()) {
					return false;
				}
				
				int lastIndex = containOpenBrackets.length() - 1;
				
				// if It's not matching with last index of openBracket and closeBracket.
				char lastOpenBracket = containOpenBrackets.charAt(lastIndex);
				
				if(!isMatchingBracket(lastOpenBracket, ch)) {
					return false;
				} 
				
				// if It's matching with last index of openBrackets and closeBracket.
				containOpenBrackets = containOpenBrackets.substring(0, lastIndex);
			}
		}
		
		// After Checking all works, if open bracket is not empty, It is not valid.
		if(!containOpenBrackets.isEmpty())
			return false;
		
		return true;
	}
	
	public boolean isMatchingBracket(char openChar, char closeChar) {
		if(openChar == '(') {
			if(closeChar == ')')
				return true;
			else 
				return false;
		} else if(openChar == '{') {
			if(closeChar == '}')
				return true;
			else
				return false;
		} else { // openChar == '['
			if(closeChar == ']')
				return true;
			else
				return false;
		}
	}
}
