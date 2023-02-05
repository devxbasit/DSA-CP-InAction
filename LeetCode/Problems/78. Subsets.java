// https://leetcode.com/problems/subsets/
class Solution {

    void recur(int nums[], int i, List<List<Integer>> powList, List<Integer> al) {

        if (i >= nums.length) {

            // creater a new deep copy
            // Java program to create a shallow copy of an arraylist using clone() method.
            // unlike Arrays.clone() that creates deep copy;

            List<Integer> temp = new ArrayList<>();

            for (int item : al)
                temp.add(item);

            powList.add(temp);
            return;

        }

        // do - pick the item

        al.add(nums[i]);

        // recur - left
        recur(nums, i + 1, powList, al);

        // undo - dont pick the item, so remove it

        al.remove(al.size() - 1);

        // recur - right

        recur(nums, i + 1, powList, al);

    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> powList = new ArrayList<>();

        List<Integer> al = new ArrayList<>();

        recur(nums, 0, powList, al);

        return powList;

    }
}