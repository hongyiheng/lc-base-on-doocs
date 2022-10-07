class Solution:
    def validSquare(self, p1: List[int], p2: List[int], p3: List[int], p4: List[int]) -> bool:
        def get_dist(a, b):
            return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1])

        ps = [p1, p2, p3, p4]
        mp = dict()
        l = float('inf')
        for i in range(4):
            for j in range(i + 1, 4):
                dist = get_dist(ps[i], ps[j])
                l = min(l, dist)
                mp[dist] = mp.get(dist, 0) + 1
        return len(mp) == 2 and mp[l] == 4
