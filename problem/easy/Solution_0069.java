package problem.easy;

/**
69. Sqrt(x)

Hint
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. 
The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 

Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.


Example 2:

Input: x = 8
Output: 2
Explanation: 
The square root of 8 is 2.82842..., 
and since we round it down to the nearest integer, 2 is returned.
 

Constraints:

0 <= x <= 2^31 - 1
 */

public class Solution_0069 {
	public int mySqrt(int x) {
        long lx = x;

        if(lx == 0){
            return 0;
        }

        long count = 1;
        while((count * count) <= lx){
            count++;
        }

        return (int)(count - 1);
    }
}

/**
Perfect Solution :
-------------------
class Solution {
    public int mySqrt(int x) {
        long l = 0, r = x;
        long res = 0;
        while(l <= r){
            long mid = l + (r-l)/2;
            long pow = mid*mid;
            if(pow > (long)x){
                r = mid - 1;
            }else if(pow == x){
                return (int)mid;
            }else{
                res = mid;
                l = mid + 1;
            }
        }

        return (int)res;
    }
}
*/