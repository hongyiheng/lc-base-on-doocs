class SmallestInfiniteSet {

    TreeSet<Integer> q;

    public SmallestInfiniteSet() {
        q = new TreeSet();
        for (int i = 1; i < 1001; i++) {
            q.add(i);
        }
    }

    public int popSmallest() {
        return q.pollFirst();
    }

    public void addBack(int num) {
        q.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */