class Solution {
    private double r;
    private double x;
    private double y;
    Random random;

    public Solution(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
        random = new Random();
    }

    public double[] randPoint() {
        while (true) {
            double nx = random.nextDouble() * 2 * r - r;
            double ny = random.nextDouble() * 2 * r - r;
            if (Math.sqrt(nx * nx + ny * ny) < r) {
                return new double[]{nx + x, ny + y};
            }
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */