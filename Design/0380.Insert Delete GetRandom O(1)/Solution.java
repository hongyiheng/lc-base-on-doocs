class RandomizedSet {
    int[] nums;
    Map<Integer, Integer> mp = new HashMap<>();
    int idx;
    Random r;

    public RandomizedSet() {
        nums = new int[200010];
        mp = new HashMap<>();
        idx = -1;
        r = new Random();
    }

    public boolean insert(int val) {
        if (mp.containsKey(val)) {
            return false;
        }
        mp.put(val, ++idx);
        nums[idx] = val;
        return true;
    }

    public boolean remove(int val) {
        if (!mp.containsKey(val)) {
            return false;
        }
        int index = mp.get(val);
        mp.remove(val);
        if (index != idx) {
            mp.put(nums[idx], index);
        }
        nums[index] = nums[idx--];
        return true;
    }

    public int getRandom() {
        return nums[r.nextInt(idx + 1)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */