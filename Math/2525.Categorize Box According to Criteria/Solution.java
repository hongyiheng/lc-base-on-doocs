class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        long v = 1L * length * width * height;
        boolean bulky = Math.max(Math.max(length, width), height) >= Math.pow(10, 4) || v >= Math.pow(10, 9);
        boolean heavy = mass >= 100;
        if (bulky && heavy) {
            return "Both";
        } else if (bulky) {
            return "Bulky";
        } else if (heavy) {
            return "Heavy";
        }
        return "Neither";
    }
}