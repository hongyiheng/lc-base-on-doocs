class SeatManager {

    PriorityQueue<Integer> q;

    public SeatManager(int n) {
        q = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
    }

    public int reserve() {
        return q.poll();
    }

    public void unreserve(int seatNumber) {
        q.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */