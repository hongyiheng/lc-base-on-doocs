class LUPrefix {

    Set<Integer> s;
    int x;

    public LUPrefix(int n) {
        s = new HashSet<>();
        x = 0;
    }

    public void upload(int video) {
        s.add(video);
    }

    public int longest() {
        while (s.contains(x + 1)) {
            x++;
        }
        return x;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */