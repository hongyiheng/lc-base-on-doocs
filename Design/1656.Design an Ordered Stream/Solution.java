class OrderedStream {
    Pair<Integer, String>[] q;
    int ptr, n;

    public OrderedStream(int n) {
        q = new Pair[n + 1];
        ptr = 1;
        this.n = n;
    }

    public List<String> insert(int idKey, String value) {
        List<String> ans = new ArrayList<>();
        q[idKey] = new Pair(idKey, value);
        while (ptr < n + 1 && q[ptr] != null) {
            ans.add(q[ptr].getValue());
            ptr++;
        }
        return ans;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */