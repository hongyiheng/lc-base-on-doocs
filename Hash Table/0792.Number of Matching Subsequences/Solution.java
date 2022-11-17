class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Deque<String>> ws = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            ws.add(new ArrayDeque<>());
        }
        for (String w : words) {
            ws.get(w.charAt(0) - 'a').addLast(w);
        }
        int ans = 0;
        for (char c : s.toCharArray()) {
            Deque<String> q = ws.get(c - 'a');
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String w = q.removeFirst();
                if (w.length() == 1) {
                    ans++;
                } else {
                    ws.get(w.charAt(1) - 'a').addLast(w.substring(1));
                }
            }
        }
        return ans;
    }
}
