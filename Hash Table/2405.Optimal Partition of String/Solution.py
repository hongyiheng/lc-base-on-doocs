class Solution:
    def partitionString(self, s: str) -> int:
        ans = mask = 0
        for c in s:
            v = ord(c) - ord('a')
            if mask >> v & 1:
                ans += 1
                mask = 0
            mask |= 1 << v
        return ans if mask == 0 else ans + 1
