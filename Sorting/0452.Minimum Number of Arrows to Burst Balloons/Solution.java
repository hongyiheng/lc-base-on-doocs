class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int res = 1;
        int right = points[0][1];
        for (int i = 0; i < points.length; i++) {
            if (right >= points[i][0]) {
                right = Math.min(right, points[i][1]);
                continue;
            }
            right = points[i][1];
            res++;
        }
        return res;
    }
}