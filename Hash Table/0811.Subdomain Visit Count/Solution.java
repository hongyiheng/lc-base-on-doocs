class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> mp = new HashMap<>();
        for (String s : cpdomains) {
            String[] ss = s.split(" ");
            int num = Integer.valueOf(ss[0]);
            String[] sss = ss[1].split("\\.");
            int n = sss.length;
            String k = sss[n - 1];
            mp.put(k, mp.getOrDefault(k, 0) + num);
            for (int i = n - 2; i >= 0; i--) {
                k = sss[i] + "." + k;
                mp.put(k, mp.getOrDefault(k, 0) + num);
            }
        }
        List<String> ans = new ArrayList<>();
        for (String k : mp.keySet()) {
            ans.add(mp.get(k) + " " + k);
        }
        return ans;
    }
}
