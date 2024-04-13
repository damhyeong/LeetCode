package problem.easy;

/**
35. Search Insert Position
Easy
Topics
Companies
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */

public class Solution_0035 {
	public static int[] numList;
    public int searchInsert(int[] nums, int target) {
        numList = nums;
        int answer = searchBinary(target, 0, nums.length - 1);
        return answer;
    }

    public int searchBinary(int target, int start, int end){
        int middleIndex = (start + end) / 2;

        if(start >= end){ // if start, end index is equal, we can define where to Insert target.
            // middleIndex == start == end
            int lastValue = numList[middleIndex]; // remaing just one value.
            if(target <= lastValue){ // if target is less or equal to lastValue, Insert That Index.
                return middleIndex;
            } else { // if target is larger than lastValue, target index is that Index + 1.
                return middleIndex + 1;
            }
        }

        if(numList[middleIndex] < target){ // if middle value is rower than target value.
            return searchBinary(target, middleIndex + 1, end);
        } else if(numList[middleIndex] > target){ // if middle value is bigger than target value;
            return searchBinary(target, start, middleIndex - 1);
        } else { // If, nums[middleIndex] == target, We found where to Insert target!!
            return middleIndex;
        }
    }
}
