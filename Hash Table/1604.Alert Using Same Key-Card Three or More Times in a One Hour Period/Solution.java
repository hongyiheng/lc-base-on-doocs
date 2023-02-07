class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String>[] t = new ArrayList[24 * 60];
        for (int i = 0; i < keyName.length; i++) {
            String[] time = keyTime[i].split(":");
            int h = Integer.parseInt(time[0]), m = Integer.parseInt(time[1]);
            int idx = h * 60 + m;
            if (t[idx] == null) {
                t[idx] = new ArrayList<>();
            }
            t[idx].add(keyName[i]);
        }
        Map<String, Integer> cnt = new HashMap<>();
        List<String> ans = new ArrayList<>();
        int l = 0, r = 0;
        while (r < 24 * 60) {
            if (r - l > 60) {
                if (t[l] != null) {
                    for (String name : t[l]) {
                        cnt.put(name, cnt.get(name) - 1);
                    }
                }
                l++;
            }
            if (t[r] != null) {
                for (String name : t[r]) {
                    cnt.put(name, cnt.getOrDefault(name, 0) + 1);
                    if (cnt.get(name) == 3) {
                        ans.add(name);
                        cnt.put(name, -0x3f3f3f3f);
                    }
                }
            }
            r++;
        }
        Collections.sort(ans);
        return ans;
    }
}
