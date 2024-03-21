class FrequencyTracker {

    Map<Integer, Integer> cnt;
    Map<Integer, Set<Integer>> freq;

    public FrequencyTracker() {
        cnt = new HashMap<>();
        freq = new HashMap<>();
    }

    public void add(int number) {
        int d = cnt.getOrDefault(number, 0);
        if (d != 0) {
            freq.get(d).remove(number);
        }
        freq.computeIfAbsent(d + 1, k -> new HashSet<>()).add(number);
        cnt.put(number, d + 1);
    }

    public void deleteOne(int number) {
        int d = cnt.getOrDefault(number, 0);
        if (d != 0) {
            freq.get(d).remove(number);
            cnt.remove(number);
        }
        if (d - 1 > 0) {
            freq.computeIfAbsent(d - 1, k -> new HashSet<>()).add(number);
            cnt.put(number, d - 1);
        }
    }

    public boolean hasFrequency(int frequency) {
        Set<Integer> s = freq.getOrDefault(frequency, new HashSet<>());
        return !s.isEmpty();
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */