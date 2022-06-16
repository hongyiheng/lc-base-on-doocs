class Solution:
    def maximumSubsequenceCount(self, text: str, pattern: str) -> int:
        a, b = pattern[0], pattern[1]
        if a == b:
            cnt = 0
            for c in text:
                if c == a:
                    cnt += 1
            return (cnt + 1) * cnt // 2
        cnt_a, cnt_b, ans = 0, 0, 0
        for c in text:
            if c == a:
                cnt_a += 1
            elif c == b:
                cnt_b += 1
                ans += cnt_a
        ans += max(cnt_a, cnt_b)
        return ans