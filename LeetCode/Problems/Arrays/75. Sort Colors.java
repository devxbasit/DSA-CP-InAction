// https://leetcode.com/problems/sort-colors/

class Solution {
    public void sortColors(int[] nums) {

        int low = -1, high = nums.length;

        int current = 0;
        while (current < high){
            
            if (nums[current] == 0) {
                
                swap(nums, low + 1, current);
                low++;
                current++;
                
            } else if (nums[current] == 2) {

                swap(nums, current, high - 1);
                high--;
            } else {
                
                current++;
                
            }
        }
        
    }

    public static void swap(int[] nums, int i, int j) {
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


// Approach 2
class Solution {
    public void sortColors(int[] nums) {

        int freq[] = new int[3];
        for (int i = 0; i < nums.length; i++)
            freq[nums[i]]++;

        for (int i = 0; i < nums.length; i++) {

            // initialize color to overcome warnings
            int color = 0;

            if (freq[0] > 0) {

                color = 0;

            } else if (freq[1] > 0) {

                color = 1;

            } else if (freq[2] > 0) {

                color = 2;

            }

            nums[i] = color;
            freq[color]--;

        }
    }

    void swap(int nums[], int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}