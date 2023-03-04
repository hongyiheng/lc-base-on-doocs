class Solution {
    public String[] getFolderNames(String[] names) {
        int n = names.length;
        Set<String> vis = new HashSet<>();
        Map<String, Integer> mp = new HashMap<>();
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            String s = names[i];
            if (vis.contains(s)) {
                int idx = mp.getOrDefault(s, 1);
                while (vis.contains(s + "(" + idx +")")) {
                    idx++;
                }
                s += "(" + idx +")";
                mp.put(s, idx + 1);
            } else {
                mp.put(s, 1);
            }
            ans[i] = s;
            vis.add(s);
        }
        return ans;
    }
}