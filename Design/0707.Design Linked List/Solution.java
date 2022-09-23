class MyLinkedList {
    Deque<Integer> q;

    public MyLinkedList() {
        q = new ArrayDeque<>();
    }

    public int get(int index) {
        if (index < 0 || index >= q.size()) {
            return -1;
        }
        Deque<Integer> tmp = new ArrayDeque<>();
        while (tmp.size() < index) {
            tmp.addLast(q.pollFirst());
        }
        int ans = q.peekFirst();
        while (!tmp.isEmpty()) {
            q.addFirst(tmp.pollLast());
        }
        return ans;
    }

    public void addAtHead(int val) {
        q.addFirst(val);
    }

    public void addAtTail(int val) {
        q.addLast(val);
    }

    public void addAtIndex(int index, int val) {
        if (index > q.size()) {
            return;
        }
        if (index == q.size()) {
            addAtTail(val);
        } else if (index <= 0) {
            addAtHead(val);
        } else {
            Deque<Integer> tmp = new ArrayDeque<>();
            while (tmp.size() < index) {
                tmp.addLast(q.pollFirst());
            }
            q.addFirst(val);
            while (!tmp.isEmpty()) {
                q.addFirst(tmp.pollLast());
            }
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= q.size()) {
            return;
        }
        Deque<Integer> tmp = new ArrayDeque<>();
        while (tmp.size() < index) {
            tmp.addLast(q.pollFirst());
        }
        q.pollFirst();
        while (!tmp.isEmpty()) {
            q.addFirst(tmp.pollLast());
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
