class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int base = 131313;
        long p = 1;
        for (int i = 0; i < 9; i++) {
            p = base * p;
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        int l = 0, r = 0, h = 0;
        while (r < s.length()) {
            h = (h * base + s.charAt(r));
            if (r - l + 1 == 10) {
                int v = map.getOrDefault(h, 0);
                if (v == 1) {
                    ans.add(s.substring(l, r + 1));
                }
                map.put(h, v + 1);
                h = (int) (h - p * s.charAt(l));
                l++;
            }
            r++;
        }
        return ans;
    }
}
