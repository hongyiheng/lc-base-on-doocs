class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        cnt = [0] * 121
        for v in ages:
            cnt[v] += 1
        ans = 0
        for i in range(121):
            if not cnt[i]:
                continue
            for j in range(121):
                if not cnt[j]:
                    continue
                if j <= 0.5 * i + 7 or j > i:
                    continue
                ans += cnt[i] * (cnt[j] - int(i == j))
        return ans
