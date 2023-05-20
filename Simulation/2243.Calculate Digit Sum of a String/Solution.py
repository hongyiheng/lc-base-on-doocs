class Solution:
    def digitSum(self, s: str, k: int) -> str:
        if len(s) <= k:
            return s
        ans = []
        cnt = cur = 0
        for c in s:
            cur += ord(c) - ord('0')
            cnt += 1
            if cnt == k:
                ans.append(str(cur))
                cnt = cur = 0
        if cnt:
            ans.append(str(cur))
        return self.digitSum("".join(ans), k)