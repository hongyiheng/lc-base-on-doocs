class MyHashSet {

    boolean[] s;

    public MyHashSet() {
        s = new boolean[1000010];
    }

    public void add(int key) {
        s[key] = true;
    }

    public void remove(int key) {
        s[key] = false;
    }

    public boolean contains(int key) {
        return s[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */