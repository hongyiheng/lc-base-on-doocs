class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while ((tx > 0 && ty > 0) && (tx > sx || ty > sy)) {
            if (tx >= ty) {
                tx = tx - Math.max(1, (tx - sx) / ty) * ty;
            } else {
                ty = ty - Math.max(1, (ty - sy) / tx) * tx;
            }
        }
        return sx == tx && sy == ty;
    }
}