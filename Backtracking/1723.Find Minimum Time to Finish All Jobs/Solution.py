class Solution:
    def minimumTimeRequired(self, jobs: List[int], k: int) -> int:
        cnt = [0] * k
        ans, n = float('inf'), len(jobs)

        def dfs(i, used, cur):
            nonlocal ans
            if cur >= ans:
                return
            if i == n:
                ans = min(ans, cur)
                return
            if used < k:
                cnt[used] = jobs[i]
                dfs(i + 1, used + 1, max(cur, jobs[i]))
                cnt[used] = 0
            for j in range(used):
                cnt[j] += jobs[i]
                dfs(i + 1, used, max(cur, cnt[j]))
                cnt[j] -= jobs[i]

        dfs(0, 0, 0)
        return ans