package problem.easy;

import java.util.*;
import java.io.*;

/**
14. Longest Common Prefix
Easy
Topics
Companies
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
 */


public class Solution_0014 {
	public String longestCommonPrefix(String[] strs) {
		// first, we need to String for comparing another common string.
        String common = strs[0];
        // Initialize Value str.
        String str = strs[0];

        // We already store first string strs. so Start index from 1.
        for(int i = 1; i < strs.length; i++){
            // string for comparing with "common".
            String newCommon = "";
            
            // string for comparing with "str" to adding chars.
            String diffStr = strs[i];
            
            // Focusing What is more large.
            for(int j = 0; j < Math.min(str.length(), diffStr.length()); j++){
                // if char at str and diffStr is same, adding char to newCommon.
                if(str.charAt(j) == diffStr.charAt(j)){
                    newCommon += str.charAt(j);
                // But if, is Not Same char, break to loop. 
                } else {
                    break;
                }
            }

            // copy to str for comparing next Step.
            str = diffStr;

            // if previous common length is larger than newCommon, Here is new common string!
            common = (common.length() > newCommon.length()) ? newCommon : common;

            // But, is Common String be Empted, theres no reason more comparing.
            if(common.equals("")){
                break;
            }
        }

        return common;
	}
}
