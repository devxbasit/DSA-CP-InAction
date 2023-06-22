// https://leetcode.com/problems/container-with-most-water/
class Solution {

  public int maxArea(int[] height) {
    int max = -1;

    int low = 0;
    int high = height.length - 1;

    while (low < high) {
      int area = (high - low) * Math.min(height[low], height[high]);

      max = area > max ? area : max;

      if (height[low] < height[high]) {
        low++;
        continue;
      }

      high--;
    }

    return max;
  }
}
