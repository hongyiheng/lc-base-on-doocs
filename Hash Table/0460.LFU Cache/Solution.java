    class LFUCache {

        Map<Integer, Integer> kv, keyFreq;
        Map<Integer, Deque<Integer>> freqKeys;
        int minFreq, capacity;

        public LFUCache(int capacity) {
            kv = new HashMap<>();
            keyFreq = new HashMap<>();
            freqKeys = new HashMap<>();
            minFreq = 0;
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!kv.containsKey(key)) {
                return -1;
            }
            incrFreq(key);
            return kv.get(key);
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (kv.containsKey(key)) {
                incrFreq(key);
            } else {
                if (kv.size() >= capacity) {
                    int delKey = freqKeys.get(minFreq).pollFirst();
                    if (freqKeys.get(minFreq).isEmpty()) {
                        freqKeys.remove(minFreq);
                    }
                    kv.remove(delKey);
                    keyFreq.remove(delKey);
                }
                keyFreq.put(key, 1);
                freqKeys.computeIfAbsent(1, k -> new ArrayDeque<>()).addLast(key);
                minFreq = 1;
            }
            kv.put(key, value);
        }

        public void incrFreq(int key) {
            int f = keyFreq.get(key);
            freqKeys.get(f).remove(key);
            if (freqKeys.get(f).isEmpty()) {
                freqKeys.remove(f);
                if (f == minFreq) {
                    minFreq++;
                }
            }
            keyFreq.put(key, f + 1);
            freqKeys.computeIfAbsent(f + 1, k -> new ArrayDeque<>()).addLast(key);
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */