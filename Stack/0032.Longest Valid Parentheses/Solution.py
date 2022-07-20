class Solution:
    def longestValidParentheses(self, s: str) -> int:
        q = []
        for i, v in enumerate("".join(s)):
            cur = 0 if v == '(' else 1
            if not q:
                q.append([cur, i])
            else:
                if cur == 1 and q[-1][0] == 0:
                    q.pop()
                else:
                    q.append([cur, i])
        nums = [0] * len(s)
        while q:
            nums[q.pop()[1]] = 1
        ans = cur = 0
        for v in nums:
            if v == 1:
                ans = max(ans, cur)
                cur = 0
            else:
                cur += 1
        ans = max(ans, cur)
        return ans