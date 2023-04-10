class Solution:
    def videoStitching(self, clips: List[List[int]], time: int) -> int:
        t = [i for i in range(110)]
        for u, v in clips:
            if v > t[u]:
                t[u] = v
        ans, cur = 1, t[0]
        while cur < time:
            mx = max(t[:cur + 1])
            if mx == cur:
                return -1
            cur = mx
            ans += 1
        return ans