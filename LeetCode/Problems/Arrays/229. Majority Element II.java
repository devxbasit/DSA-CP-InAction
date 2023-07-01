// https://leetcode.com/problems/majority-element-ii/description/
// https://www.youtube.com/watch?v=vwZj1K0e9U8

// TC -> O(N)
class Solution {

  public List<Integer> majorityElement(int[] nums) {
    int candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE, vote1 =
      0, vote2 = 0;

    for (int i = 0; i < nums.length; i++) {
      if (vote1 == 0 && candidate2 != nums[i]) {
        candidate1 = nums[i];
        vote1 = 1;
      } else if (vote2 == 0 && candidate1 != nums[i]) {
        candidate2 = nums[i];
        vote2 = 1;
      } else if (nums[i] == candidate1) {
        vote1++;
      } else if (nums[i] == candidate2) {
        vote2++;
      } else {
        vote1--;
        vote2--;
      }
    }

    int counter1 = 0, counter2 = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == candidate1) {
        counter1++;
      }

      if (nums[i] == candidate2) {
        counter2++;
      }
    }

    int min = nums.length / 3;

    List<Integer> list = new ArrayList<>();

    if (counter1 > min) {
      list.add(candidate1);
    }

    if (counter2 > min) {
      list.add(candidate2);
    }

    return list;
  }
}
// Approach2 - frequency count, hashing
