class mat {

  public static void main(String[] args) {
    String text = "aabaababbaabacb";
    String pattern = "aaba";
    // String pattern = "a";
    // String pattern = "ab";
    int freq = 0;

    int n = text.length();
    int m = pattern.length();

    char firstCh = pattern.charAt(0);
    char lastCh = pattern.charAt(m - 1);

    for (int i = 0; i < n - m; i++) {
      if (text.charAt(i) == firstCh && text.charAt(i + m - 1) == lastCh) {
        freq++;
        int j = 1;
        int k = i + 1;

        while (j < m - 1) {
          if (text.charAt(k) != pattern.charAt(j)) {
            freq--;
            break;
          }
          j++;
          k++;
        }
      }
    }
    System.out.printf("Frequency of \"%s\" is %d\n", pattern, freq);
  }
}
