class MyHashMap {

    int[] s;

    public MyHashMap() {
        s = new int[1000010];
        Arrays.fill(s, -1);
    }

    public void put(int key, int value) {
        s[key] = value;
    }

    public int get(int key) {
        return s[key];
    }

    public void remove(int key) {
        s[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */