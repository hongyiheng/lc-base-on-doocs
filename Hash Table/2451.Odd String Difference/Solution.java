class Solution {
    public String oddString(String[] words) {
        Map<String, Integer> mp = new HashMap<>();
        Map<String, String> ws = new HashMap<>();
        for (String w : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < w.length(); i++) {
                sb.append(w.charAt(i) - w.charAt(i - 1) + ",");
            }
            String k = sb.toString();
            mp.put(k, mp.getOrDefault(k, 0) + 1);
            ws.put(k, w);
        }
        String ans = "";
        for (String k : mp.keySet()) {
            if (mp.get(k) == 1) {
                ans = k;
                break;
            }
        }
        return ws.get(ans);
    }
}
