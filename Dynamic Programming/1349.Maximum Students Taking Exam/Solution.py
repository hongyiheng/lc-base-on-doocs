class Solution:
    def maxStudents(self, seats: List[List[str]]) -> int:
        def dfs(i, mask):
            if i == n:
                masks.add(mask)
                return
            if not i or mask >> (i - 1) & 1 == 0:
                dfs(i + 1, mask | 1 << i)
            dfs(i + 1, mask)

        def check(u, v):
            for i in range(n):
                if not v >> i & 1:
                    continue
                if i > 0 and u >> (i - 1) & 1:
                    return False
                if i < n - 1 and u >> (i + 1) & 1:
                    return False
            return True

        def get_val(mask, i):
            ans = 0
            for j in range(n):
                if mask >> j & 1 and seats[i][j] == '.':
                    ans += 1
            return ans

        m, n = len(seats), len(seats[0])
        masks = set()
        dfs(0, 0)
        g = defaultdict(list)
        for u in masks:
            for v in masks:
                if check(u, v):
                    g[v].append(u)

        f = defaultdict(int)
        for mask in masks:
            f[(0, mask)] = get_val(mask, 0)

        for i in range(1, m):
            for mask in masks:
                v = get_val(mask, i)
                for last_m in g[mask]:
                    f[(i, mask)] = max(f[(i, mask)], f[(i - 1, last_m)] + v)

        return max([f[(m - 1, mask)] for mask in masks])