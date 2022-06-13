class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        cnt = [0] * 101
        for v in heights:
            cnt[v] += 1
        idx, ans = 1, 0
        for v in heights:
            while cnt[idx] == 0:
                idx += 1
            if idx != v:
                ans += 1
            cnt[idx] -= 1
        return ans