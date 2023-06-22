class Solution {

  // Function to count the frequency of all elements from 1 to N in the array.
  public static void frequencyCount(int arr[], int N, int P) {
    // https://www.geeksforgeeks.org/count-frequencies-elements-array-o1-extra-space-time/

    // #ImportantQuestionTag

    int i = 0;

    while (i < arr.length) {
      if (arr[i] <= 0) {
        i++;
        continue;
      }

      if (arr[i] > arr.length) {
        arr[i] = 0;
        i++;
        continue;
      }

      if (arr[arr[i] - 1] <= 0) {
        arr[arr[i] - 1]--;
        arr[i] = 0;
        i++;
      } else {
        int temp = arr[i];
        arr[i] = arr[arr[i] - 1];
        arr[temp - 1] = -1;
      }
    }

    for (int j = 0; j < arr.length; j++) {
      if (arr[j] < 0) {
        arr[j] *= -1;
      }
    }
  }
}
