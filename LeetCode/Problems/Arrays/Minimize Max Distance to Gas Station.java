// https://www.codingninjas.com/studio/problems/minimise-max-distance_7541449
// https://www.youtube.com/watch?v=kMSBvlZ-_HA

import java.util.*;

// TC -> O(NLogN) + O(kLogN)
// TC -> O(N - 1) + O(N - 1)
public class Solution {

  public static double MinimiseMaxDistance(int[] nums, int k) {
    //PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    int[] howManyPlaced = new int[nums.length - 1];

    for (int i = 0; i < nums.length - 1; i++) {
      pq.add(new Pair(nums[i + 1] - nums[i], i));
    }

    while (k > 0) {
      Pair head = pq.poll();

      int actualDiff = nums[head.index + 1] - nums[head.index];
      double newSectionLength = (double) actualDiff /
      (howManyPlaced[head.index] + 2);

      k--;
      howManyPlaced[head.index]++;

      pq.add(new Pair(newSectionLength, head.index));
    }

    return pq.peek().distance;
  }
}

class Pair implements Comparable<Pair> {

  public double distance;
  public int index;

  public Pair(double distance, int index) {
    this.distance = distance;
    this.index = index;
  }

  public int compareTo(Pair otherPair) {
    return otherPair.distance >= this.distance ? 1 : -1;
  }
}
