class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        def lowbit(x):
            return x & -x

        def query(x):
            ans = 0
            while x > 0:
                ans += self.tree[x]
                x -= lowbit(x)
            return ans

        def add(x, incr):
            while x < len(self.tree):
                self.tree[x] += incr
                x += lowbit(x)

        n = len(nums)
        pre = [0] * (n + 1)
        for i, v in enumerate(nums, 1):
            pre[i] = pre[i - 1] + nums[i - 1]
        s = set()
        for v in pre:
            s.add(v)
            s.add(v - upper)
            s.add(v - lower)
        mp = dict()
        idx = 1
        for v in sorted(s):
            mp[v] = idx
            idx += 1
        self.tree = [0] * (len(mp) + 1)
        ans = 0
        for v in pre:
            l, r = mp[v - upper] - 1, mp[v - lower]
            ans += query(r) - query(l)
            add(mp[v], 1)
        return ans