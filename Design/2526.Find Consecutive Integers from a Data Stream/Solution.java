class DataStream {

    int v, k, cnt;

    public DataStream(int value, int k) {
        v = value;
        this.k = k;
        cnt = 0;
    }

    public boolean consec(int num) {
        cnt = num == v ? cnt + 1 : 0;
        return cnt >= k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */