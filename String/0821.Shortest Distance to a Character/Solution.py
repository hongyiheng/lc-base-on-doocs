class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        chars = []
        for i, v in enumerate(s):
            if v == c:
                chars.append(i)
        n = len(s)
        ans = [0] * n
        idx = 0
        left, right = float("-inf"), chars[idx]
        for i, v in enumerate(s):
            if right < i and idx < len(chars) - 1:
                idx += 1
                left = right
                right = chars[idx]
            ans[i] = min(abs(left - i), abs(right - i))
        return ans