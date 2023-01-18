class MKAverage {

    int m;
    int k;
    Deque<Integer> nums;
    TreeMap<Integer, Integer> lo;
    TreeMap<Integer, Integer> hi;
    TreeMap<Integer, Integer> mid;
    int loSize, hiSize, midSize;
    long s;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        nums = new ArrayDeque<>(m);
        lo = new TreeMap<>();
        hi = new TreeMap<>();
        mid = new TreeMap<>();
        s = 0;
    }

    public void addElement(int num) {
        nums.addLast(num);
        if (lo.isEmpty() || num <= lo.lastKey()) {
            lo.put(num, lo.getOrDefault(num, 0) + 1);
            loSize++;
        } else if (hi.isEmpty() || num >= hi.firstKey()) {
            hi.put(num, hi.getOrDefault(num, 0) + 1);
            hiSize++;
        } else {
            mid.put(num, mid.getOrDefault(num, 0) + 1);
            midSize++;
            s += num;
        }

        if (nums.size() > m) {
            int remove = nums.pollFirst();
            if (remove <= lo.lastKey()) {
                lo.put(remove, lo.get(remove) - 1);
                if (lo.get(remove) == 0) {
                    lo.remove(remove);
                }
                loSize--;
            } else if (remove >= hi.firstKey()) {
                hi.put(remove, hi.get(remove) - 1);
                if (hi.get(remove) == 0) {
                    hi.remove(remove);
                }
                hiSize--;
            } else {
                mid.put(remove, mid.get(remove) - 1);
                if (mid.get(remove) == 0) {
                    mid.remove(remove);
                }
                midSize--;
                s -= remove;
            }
        }

        if (nums.size() == m) {
            while (loSize > k) {
                int remove = lo.lastKey();
                lo.put(remove, lo.get(remove) - 1);
                if (lo.get(remove) == 0) {
                    lo.remove(remove);
                }
                loSize--;
                mid.put(remove, mid.getOrDefault(remove, 0) + 1);
                midSize++;
                s += remove;
            }
            while (hiSize > k) {
                int remove = hi.firstKey();
                hi.put(remove, hi.get(remove) - 1);
                if (hi.get(remove) == 0) {
                    hi.remove(remove);
                }
                hiSize--;
                mid.put(remove, mid.getOrDefault(remove, 0) + 1);
                midSize++;
                s += remove;
            }
            while (midSize > m - 2 * k) {
                if (loSize < k) {
                    int remove = mid.firstKey();
                    mid.put(remove, mid.get(remove) - 1);
                    if (mid.get(remove) == 0) {
                        mid.remove(remove);
                    }
                    s -= remove;
                    lo.put(remove, lo.getOrDefault(remove, 0) + 1);
                    loSize++;
                } else {
                    int remove = mid.lastKey();
                    mid.put(remove, mid.get(remove) - 1);
                    if (mid.get(remove) == 0) {
                        mid.remove(remove);
                    }

                    s -= remove;
                    hi.put(remove, hi.getOrDefault(remove, 0) + 1);
                    hiSize++;
                }
                midSize--;
            }
        }
    }

    public int calculateMKAverage() {
        if (nums.size() != m) {
            return -1;
        }
        return (int) (s / (m - 2 * k));
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */
