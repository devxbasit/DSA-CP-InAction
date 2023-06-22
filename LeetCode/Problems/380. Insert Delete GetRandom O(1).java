// https://leetcode.com/problems/insert-delete-getrandom-o1/
class RandomizedSet {

  HashMap<Integer, Integer> hm;
  List<Integer> al;

  /** Initialize your data structure here. */
  public RandomizedSet() {
    hm = new HashMap<>();
    al = new ArrayList<>();
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain
   * the specified element.
   */
  public boolean insert(int val) {
    if (al.isEmpty()) {
      hm.put(val, 0);
      al.add(val);

      return true;
    }

    if (hm.containsKey(val)) return false;

    hm.put(val, al.size());
    al.add(val);

    return true;
  }

  /**
   * Removes a value from the set. Returns true if the set contained the specified
   * element.
   */

  public boolean remove(int val) {
    if (al.isEmpty() || !hm.containsKey(val)) return false;

    if (al.size() == 1) {
      hm.remove(al.get(0));
      al.remove(0);

      return true;
    }

    int i = hm.get(val);

    if (i == al.size() - 1) {
      hm.remove(val);
      al.remove(al.size() - 1);
      return true;
    }

    // else swap

    int lastVal = al.get(al.size() - 1);

    // update lastVal's index in hashmap
    hm.put(lastVal, i);

    // copy lastval to ith index
    al.set(i, lastVal);

    // remove last
    al.remove(al.size() - 1);
    hm.remove(val);

    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    Random rnd = new Random();

    return al.get(rnd.nextInt(al.size()));
  }
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
