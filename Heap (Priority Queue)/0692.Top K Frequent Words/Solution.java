class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> mp = new HashMap<>();
        for (String w : words) {
            mp.put(w, mp.getOrDefault(w, 0) + 1);
        }
        PriorityQueue<Pair<Integer, String>> q = new PriorityQueue<>((a, b) -> {
            if (!a.getKey().equals(b.getKey())) {
                return a.getKey() - b.getKey();
            }
            return b.getValue().compareTo(a.getValue()) > 0 ? 1 : -1;
        });
        for (String w : mp.keySet()) {
            q.add(new Pair<>(mp.get(w), w));
            if (q.size() > k) {
                q.poll();
            }
        }
        Deque<String> ans = new ArrayDeque<>();
        while (!q.isEmpty()) {
            ans.addFirst(q.poll().getValue());
        }
        return new ArrayList<>(ans);
    }
}