// https://leetcode.com/problems/wiggle-sort-ii/

class Solution {

    public void wiggleSort(int[] nums) {

        Arrays.sort(nums);

        int temp[] = new int[nums.length];

        int j = nums.length - 1;

        int i = 1;

        while (i < nums.length) {

            temp[i] = nums[j];
            i = i + 2;
            j--;

        }

        i = 0;

        while (i < nums.length) {

            temp[i] = nums[j];
            i = i + 2;
            j--;

        }

        for (i = 0; i < nums.length; i++) {

            nums[i] = temp[i];

        }

    }
}