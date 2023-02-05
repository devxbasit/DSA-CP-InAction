// https://leetcode.com/problems/group-anagrams/
class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> al = new ArrayList<>();

        Map<String, List<String>> hm = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            char charArr[] = strs[i].toCharArray();
            Arrays.sort(charArr);

            String key = new String(charArr);

            if (!hm.containsKey(key)) {

                List<String> s = new ArrayList<>();
                s.add(strs[i]);

                hm.put(key, s);
                continue;

            }

            hm.get(key).add(strs[i]);

        }

        for (Map.Entry<String, List<String>> entry : hm.entrySet()) {

            al.add(entry.getValue());

        }

        return al;
    }
}
