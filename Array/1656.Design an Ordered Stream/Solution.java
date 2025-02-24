class OrderedStream {

    String[] ws;
    int i = 0;

    public OrderedStream(int n) {
        ws = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        ws[idKey - 1] = value;
        List<String> ans = new ArrayList<>();
        while (i < ws.length && ws[i] != null) {
            ans.add(ws[i++]);
        }
        return ans;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */