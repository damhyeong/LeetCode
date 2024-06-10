package problem.hard;

public class Solution_0004 {
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length == 1 && nums2.length == 0){
            return nums1[0];
        } else if(nums2.length == 1 && nums1.length == 0){
            return nums2[0];
        }

        int[] arr = new int[nums1.length + nums2.length];

        int i = 0, j = 0, index = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j])
                arr[index++] = nums1[i++];
            else
                arr[index++] = nums2[j++];
        }

        while(i < nums1.length)
            arr[index++] = nums1[i++];
        
        while(j < nums2.length)
            arr[index++] = nums2[j++];

        double result = 0;
        index = arr.length / 2;
        if(arr.length % 2 == 0){
            double num1 = arr[index - 1];
            double num2 = arr[index];

            result = (num1 + num2) / 2;
        } else {
            result = (double)arr[index];
        }
        return result;
    }
}
