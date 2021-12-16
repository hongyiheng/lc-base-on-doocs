class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int x = location.get(0), y = location.get(1);
        List<Double> list = new ArrayList<>();
        int extra = 0;
        double pi = Math.PI, t = angle * pi / 180;
        for (List<Integer> p : points) {
            int a = p.get(0), b = p.get(1);
            if (a == x && b == y) {
                extra++;
                continue;
            }
            list.add(Math.atan2(a - x, b - y) + pi);
        }
        Collections.sort(list);
        int n = list.size(), max = 0;
        for (int i = 0; i < n; i++) {
            list.add(list.get(i) + 2 * pi);
        }
        for (int l = 0, r = 0; r < 2 * n; r++) {
            while (l < r && list.get(r) - list.get(l) > t){
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return extra + max;
    }
}