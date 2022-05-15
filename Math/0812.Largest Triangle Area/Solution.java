class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double ans = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = j; k < n; k++) {
                    double a = edge(points[i], points[j]);
                    double b = edge(points[j], points[k]);
                    double c = edge(points[i], points[k]);
                    ans = Math.max(ans, getArea(a, b, c));
                }
            }
        }
        return ans;
    }

    public double edge(int[] u, int[] v) {
        double a = u[0] - v[0], b = u[1] - v[1];
        return Math.sqrt(a * a + b * b);
    }

    public double getArea(double a, double b, double c) {
        double p = (a + b + c) * 0.5;
        double num = p * (p - a) * (p - b) * (p - c);
        if (num <= 0) {
            return 0;
        }
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}