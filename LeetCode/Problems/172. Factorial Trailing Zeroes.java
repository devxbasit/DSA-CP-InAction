// https://leetcode.com/problems/factorial-trailing-zeroes/

class Solution {

  public int trailingZeroes(int n) {
    int count = 0;

    // https://www.youtube.com/watch?v=5j24Jepc5GI&ab_channel=RakeshYadavReadersPublication
    // https://www.youtube.com/watch?v=XGbOiYhHY2c&ab_channel=mathantics

    while (n >= 5) {
      count += n / 5;
      n = n / 5;
    }

    return count;
  }
}
