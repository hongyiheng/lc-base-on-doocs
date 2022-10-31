class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int a = event2[1].compareTo(event1[0]);
        int b = event1[1].compareTo(event2[0]);
        return a >= 0 && b >= 0;
    }
}
