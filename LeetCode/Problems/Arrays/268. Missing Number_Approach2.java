// https://leetcode.com/problems/missing-number/description/
class Solution {
    public int missingNumber(int[] nums) {

        Arrays.sort(nums);

        return BinarySearch(nums, 0, nums.length - 1);
        
    }

    public int BinarySearch(int[] nums, int low, int high) {

        if (low > high) return low;
        
        int mid = low + (high - low) / 2;


        if (mid != 0 && mid != nums[mid] && (mid == 0 || mid - 1 == nums[mid - 1])) return mid;


        if (nums[mid] > mid)  {
            
            return BinarySearch(nums, low, mid - 1); 

        } else  {
            return BinarySearch(nums, mid + 1, high);
        }
    }
}