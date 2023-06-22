class Solution {

  static long sumOfDivisors(int N) {
    // code here
    // https://www.youtube.com/watch?v=tDM6lT-qjys

    int arr[] = new int[N + 1];

    long sum = 0;

    for (int i = 1; i <= N; i++) {
      for (int j = i; j <= N; j += i) {
        sum += i;
      }
    }
    return sum;
  }
}
