package problem;

/**
1. Two Sum
Easy
Topics
Companies
Hint

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9

Only one valid answer exists.
 

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */


public class Solution_0001 {
	public int[] twoSum(int[] nums, int target) {
        // Make int Array for Return.
        int[] returnArr = new int[2];
        boolean isBreak = false;
        
        for(int i = 0; i < nums.length - 1 && isBreak == false; i++){
            isBreak = false;

            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    returnArr[0] = i;
                    returnArr[1] = j;
                    isBreak = true;
                    break;
                }
            }

        }
        return returnArr;

    }
}
