/**
 * // This is the FontInfo's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface FontInfo {
 *     // Return the width of char ch when fontSize is used.
 *     public int getWidth(int fontSize, char ch) {}
 *     // Return Height of any char when fontSize is used.
 *     public int getHeight(int fontSize)
 * }
 */
class Solution {
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int l = 0, r = fonts.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (fontInfo.getHeight(fonts[mid]) <= h) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        char[] chars = text.toCharArray();
        for (int i = l; i >= 0; i--) {
            int font = fonts[i];
            int weight = 0;
            for (char c : chars) {
                weight += fontInfo.getWidth(font, c);
                if (weight > w) {
                    break;
                }
            }
            if (weight <= w) {
                return font;
            }
        }
        return -1;
    }
}