import java.util.HashSet;
import java.util.jar.Manifest;

class DSU {

  public static int findSet(int parent[], int size[], int x) {
    if (parent[x] == x) {
      size[x] = 1;
      return x;
    }

    return parent[x] = findSet(parent, size, parent[x]);
  }

  public static void unionSet(int parent[], int size[], int x, int y) {
    int px = findSet(parent, size, x);
    int py = findSet(parent, size, y);

    // both belong to same set, if we will merge them, it will form cycle
    if (px == py) return;

    if (size[px] < size[py]) {
      parent[px] = py;
      size[py] += size[px];
      return;
    }
    parent[py] = px;
    size[px] += size[py];
  }

  public static void main(String[] args) {
    int parent[] = new int[10];
    int size[] = new int[10];

    int p = parent.length;
    int s = size.length;

    for (int i = 1; i < p; i++) parent[i] = i;

    for (int i = 0; i < s; i++) size[i] = 1;

    // Set 1 = {1, 2, 4, 6}
    unionSet(parent, size, 1, 2);
    unionSet(parent, size, 4, 6);
    unionSet(parent, size, 6, 1);
    unionSet(parent, size, 6, 1);

    // Set 2 = {3, 5}
    unionSet(parent, size, 3, 5);

    // Set 3 = {0, 9, 7, 8}
    unionSet(parent, size, 0, 9);
    unionSet(parent, size, 7, 8);
    unionSet(parent, size, 8, 9);

    int groups = 0;
    for (int i = 0; i < p; i++) if (parent[i] == i) {
      System.out.printf("Group Leader/representative %d\n", i);
      groups++;
    }

    System.out.printf("Total No. of groups = %d\n", groups);
  }
}
