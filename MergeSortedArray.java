


/*

Given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

Example num1 [2,3], num2 [1,4] output [1,2,3,4]

# Approach
We can merge the arrays by filling nums1 from the back to avoid overwriting elements.
Start comparing the largest elements of nums1 (from index m - 1) and nums2 (from index n - 1),
and place the largest of the two at the last position (m + n - 1) of nums1. Decrease indices accordingly.

        - Time complexity:
The program iterates over both arrays nums1 and nums2 at most once:

        Merging:
        The first while loop iterates until either p1 (index for nums1) or p2 (index for nums2) is exhausted.
        This loop runs O(m + n) times in total since each element from both arrays is processed exactly once.
        The second while loop (copying remaining elements of nums2 to nums1) iterates over any leftover elements in nums2, which takes at most O(n) iterations in the worst case.
        Thus, the overall time complexity is:
        𝑂(𝑚+n)-->

        - Space complexity:
<!--The program performs the merge in-place, modifying the nums1 array directly without using any extra storage. Therefore, the space complexity is: O(1) -->

        */

import java.util.Arrays;

public class MergeSortedArray{
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m+n-1;
        int p1 = m-1;
        int p2 = n-1;
        while(p1 >=0 && p2>= 0)
        {
            if(nums1[p1]>nums2[p2])
            {
                nums1[p] = nums1[p1];
                p1--;
            } else
            {
                nums1[p] = nums2[p2];
                p2 --;
            }
            p--;
        }

        while(p2>=0)
        {
            nums1[p] =nums2[p2];
            p--;
            p2--;
        }


    }

    public static void main(String ... var) {
        int[] num1 = {2,3,0,0};
        int[] num2 = {1,4};
        MergeSortedArray.merge(num1, 2, num2, 2);
        System.out.println("Merged nums1: " + Arrays.toString(num1));
    }
}