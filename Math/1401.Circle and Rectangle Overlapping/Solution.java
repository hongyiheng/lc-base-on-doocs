class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x = x1 <= xCenter && xCenter <= x2 ? 0 : Math.min(Math.abs(x1 - xCenter), Math.abs(x2 - xCenter));
        int y = y1 <= yCenter && yCenter <= y2 ? 0 : Math.min(Math.abs(y1 - yCenter), Math.abs(y2 - yCenter));
        return x * x + y * y <= radius * radius;
    }
}
