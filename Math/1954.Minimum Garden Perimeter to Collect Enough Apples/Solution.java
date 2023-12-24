class Solution {
    public long minimumPerimeter(long neededApples) {
        int i = 1;
        long c = 1, s = 12;
        while (s < neededApples) {
            c = c + (2 * i) - 1;
            c += (i + 1) * 2 * 2;
            s += (c + i + 1) * 4;
            i++;
        }
        return (2 * i - 1) * 4 + 4;
    }
}