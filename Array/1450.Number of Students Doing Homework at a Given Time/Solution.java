class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int[] q = new int[1010];
        for (int v : startTime) {
            q[v]++;
        }
        for (int v : endTime) {
            q[v + 1]--;
        }
        return Arrays.stream(q).limit(queryTime + 1).sum();
    }
}