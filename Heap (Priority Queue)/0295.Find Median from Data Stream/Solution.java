class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>();
        minHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (minHeap.isEmpty()) {
            minHeap.add(num);
            return;
        }
        if (maxHeap.size() == minHeap.size()) {
            if (num < minHeap.peek()) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
        } else if (maxHeap.size() > minHeap.size()) {
            if (num < maxHeap.peek()) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            }
        } else {
            if (num < minHeap.peek()) {
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            } else {
                maxHeap.add(num);
            }
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */