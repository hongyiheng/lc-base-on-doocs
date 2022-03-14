class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Set<String> ans = new HashSet<>();
        int index = Integer.MAX_VALUE;
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            mp.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (mp.containsKey(list2[i])) {
                int j = mp.get(list2[i]);
                if (i + j > index) {
                    continue;
                }
                if (i + j < index) {
                    index = i + j;
                    ans.clear();
                }
                ans.add(list2[i]);
            }
        }
        String[] res = new String[ans.size()];
        int i = 0;
        for (String s : ans) {
            res[i++] = s;
        }
        return res;
    }
}