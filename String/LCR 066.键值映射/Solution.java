class MapSum {

    /** Initialize your data structure here. */
    Map<String, Integer> g;

    public MapSum() {
        g = new HashMap<>();
    }

    public void insert(String key, int val) {
        g.put(key, val);
    }

    public int sum(String prefix) {
        int ans = 0;
        for (Map.Entry<String, Integer> entry : g.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                ans += entry.getValue();
            }
        }
        return ans;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */