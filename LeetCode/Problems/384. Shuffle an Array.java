// https://leetcode.com/problems/shuffle-an-array/
class Solution {

    int original[];
    int array[];

    public Solution(int[] nums) {

        array = nums;
        original = nums.clone();

    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {

        if (original == null)
            return null;

        array = original;

        original = original.clone();

        return array;

    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {

        if (array == null)
            return null;

        Random rnd = new Random();

        for (int i = array.length - 1; i > 0; i--) {

            // inclusive i
            // exclusive i + 1

            int r = rnd.nextInt(i + 1);

            int temp = array[r];
            array[r] = array[i];
            array[i] = temp;

        }

        return array;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */