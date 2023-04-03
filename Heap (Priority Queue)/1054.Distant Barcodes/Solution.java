class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int m = 100010;
        int[] cnt = new int[m];
        for (int v : barcodes) {
            cnt[v] += 1;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] != a[0] ? b[0] - a[0] : b[1] - a[1]);
        for (int i = 0; i < m; i++) {
            if (cnt[i] != 0) {
                q.add(new int[]{cnt[i], i});
            }
        }
        int i = 0;
        while (!q.isEmpty()) {
            int[] mx = q.poll();
            barcodes[i++] = mx[1];
            if (!q.isEmpty()) {
                int[] nmx = q.poll();
                barcodes[i++] = nmx[1];
                if (nmx[0] - 1 != 0) {
                    q.add(new int[]{nmx[0] - 1, nmx[1]});
                }
            }
            if (mx[0] - 1 != 0) {
                q.add(new int[]{mx[0] - 1, mx[1]});
            }
        }
        return barcodes;
    }
}
