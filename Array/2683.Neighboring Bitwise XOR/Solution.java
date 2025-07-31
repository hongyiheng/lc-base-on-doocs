class Solution {

    public boolean check(int[] derived, int head) {
        int last = head;
        for (int i = 0; i < derived.length - 1; i++) {
            if (derived[i] == 1) {
                last ^= 1;
            }
        }
        return (last ^ head) == derived[derived.length - 1];
    }

    public boolean doesValidArrayExist(int[] derived) {
        return check(derived, 0) || check(derived, 1);
    }
}