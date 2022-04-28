class TimeMap {
    Map<String, String> mp;
    Map<String, List<Integer>> ts;

    public TimeMap() {
        mp = new HashMap<>();
        ts = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        mp.put(key + timestamp, value);
        ts.computeIfAbsent(key, k -> new ArrayList<>()).add(timestamp);
    }

    public String get(String key, int timestamp) {
        if (mp.containsKey(key + timestamp)) {
            return mp.get(key + timestamp);
        }
        if (!ts.containsKey(key)) {
            return "";
        }
        List<Integer> allTs = ts.get(key);
        int left = 0, right = allTs.size() - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (allTs.get(mid) <= timestamp) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return allTs.get(left) <= timestamp ? mp.get(key + allTs.get(left)) : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */