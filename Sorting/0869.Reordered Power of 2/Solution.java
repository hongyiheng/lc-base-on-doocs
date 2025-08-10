class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] cs = String.valueOf(n).toCharArray();
        Arrays.sort(cs);
        String t = new String(cs);
        for (int i = 0; i < 32; i++) {
            cs = String.valueOf(1 << i).toCharArray();
            Arrays.sort(cs);
            if (new String(cs).equals(t)) {
                return true;
            }
        }
        return false;
    }
}