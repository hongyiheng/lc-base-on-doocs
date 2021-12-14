class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int sum = 0;
        for (int[] c : courses) {
            int dur = c[0], end = c[1];
            sum += dur;
            q.offer(dur);
            if (sum > end) {
                sum -= q.poll();
            }
        }
        return q.size();
    }
}