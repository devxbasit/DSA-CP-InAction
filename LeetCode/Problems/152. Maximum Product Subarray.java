// https://leetcode.com/problems/maximum-product-subarray/
class Solution {

  // https://www.youtube.com/watch?v=0exOBHgzApE&t=251s&ab_channel=CodingNinjas
  // https://www.youtube.com/watch?v=hJ_Uy2DzE08&t=150s&ab_channel=KnowledgeCenter

  public int maxProduct(int[] nums) {
    int maxSoFar = nums[0];

    int currMax = nums[0];
    int currMin = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int temp = currMax;

      currMax =
        Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));
      currMin = Math.min(nums[i], Math.min(temp * nums[i], currMin * nums[i]));

      maxSoFar = Math.max(maxSoFar, Math.max(currMax, currMin));
    }

    return maxSoFar;
  }
}

// https://www.youtube.com/watch?v=hnswaLJvr6g

// TC -> O(3N) = O(N)
// SC -> O(2N) = O(N)
class Solution {

  public int maxProduct(int[] nums) {
    int[] prefixProduct = new int[nums.length];
    int[] suffixProduct = new int[nums.length];

    int negativeNumCount = 0;
    boolean isZeroPresent = false;

    prefixProduct[0] = nums[0];

    if (nums[0] < 0) negativeNumCount++;
    if (nums[0] == 0) isZeroPresent = true;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < 0) negativeNumCount++;
      if (nums[i] == 0) isZeroPresent = true;

      if (nums[i - 1] == 0) {
        prefixProduct[i] = nums[i];
      } else {
        prefixProduct[i] = prefixProduct[i - 1] * nums[i];
      }
    }

    if (
      !isZeroPresent && negativeNumCount % 2 == 0
    ) return prefixProduct[prefixProduct.length - 1];

    suffixProduct[suffixProduct.length - 1] = nums[nums.length - 1];

    for (int i = suffixProduct.length - 2; i > -1; i--) {
      if (nums[i + 1] == 0) {
        suffixProduct[i] = nums[i];
      } else {
        suffixProduct[i] = suffixProduct[i + 1] * nums[i];
      }
    }

    int maxProduct = Integer.MIN_VALUE;

    for (int i = 0; i < prefixProduct.length; i++) {
      maxProduct = Math.max(maxProduct, prefixProduct[i]);
      maxProduct = Math.max(maxProduct, suffixProduct[i]);
      maxProduct = Math.max(maxProduct, nums[i]);
    }

    return maxProduct;
  }
}

// https://www.youtube.com/watch?v=hnswaLJvr6g

// TC -> O(N)
class Solution {

  public int maxProduct(int[] nums) {
    int prefix = 1;
    int suffix = 1;

    int maxProduct = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      prefix *= nums[i];
      suffix *= nums[(nums.length - i) - 1];

      maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));

      if (prefix == 0) prefix = 1;
      if (suffix == 0) suffix = 1;
    }

    return maxProduct;
  }
}
