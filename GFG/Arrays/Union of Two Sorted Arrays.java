class Solution {

  // Function to return a list containing the union of the two arrays.
  public static ArrayList<Integer> findUnion(
    int arr1[],
    int arr2[],
    int n,
    int m
  ) {
    // add your code here

    int i = 0;
    int j = 0;

    var unionList = new ArrayList<Integer>();

    while (i < arr1.length && j < arr2.length) {
      // skip over duplicates
      while (i < arr1.length - 1 && arr1[i] == arr1[i + 1]) i++;
      while (j < arr2.length - 1 && arr2[j] == arr2[j + 1]) j++;

      if (arr1[i] == arr2[j]) {
        unionList.add(arr1[i]);

        i++;
        j++;
      } else if (arr1[i] < arr2[j]) {
        unionList.add(arr1[i]);
        i++;
      } else {
        unionList.add(arr2[j]);
        j++;
      }
    }

    // process remaining

    while (i < arr1.length) {
      while (i < arr1.length - 1 && arr1[i] == arr1[i + 1]) i++;

      unionList.add(arr1[i]);

      i++;
    }

    while (j < arr2.length) {
      while (j < arr2.length - 1 && arr2[j] == arr2[j + 1]) j++;

      unionList.add(arr2[j]);

      j++;
    }

    return unionList;
  }
}
