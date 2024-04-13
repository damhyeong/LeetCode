package problem.easy;

/**
28. Find the Index of the First Occurrence in a String
Easy
Topics
Companies
Given two strings needle and haystack, 
return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 

Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
 */

public class Solution_0028 {
	public int strStr(String haystack, String needle) {

        return findIndex(haystack, needle); // if doesn't using Java API.
        // return haystack.indexOf(needle);
    }

    public int findIndex(String haystack, String needle){
        int index = -1;

        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            String partOfStr = haystack.substring(i, needle.length() + i);
            if(partOfStr.equals(needle)){
                return i;
            }
        }
        return index;
    }
}
