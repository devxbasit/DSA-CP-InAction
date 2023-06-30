//https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1

class Solution {

  //Function to find the leaders in the array.
  static ArrayList<Integer> leaders(int nums[], int n) {
    // Your code here

    int maxSoFar = Integer.MIN_VALUE;
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = nums.length - 1; i > -1; i--) {
      if (nums[i] >= maxSoFar) {
        list.add(nums[i]);
        maxSoFar = nums[i];
      }
    }

    Collections.reverse(list);

    return list;
  }
}
