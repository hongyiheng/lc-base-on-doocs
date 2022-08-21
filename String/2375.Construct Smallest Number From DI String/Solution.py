class Solution:
    def smallestNumber(self, pattern: str) -> str:
        n, idx = len(pattern), 0
        ans = [str(i) for i in range(1, n + 2)]
        while idx < n:
            if pattern[idx] == "I":
                idx += 1
                continue
            start = idx
            idx += 1
            while idx < n and pattern[idx] == "D":
                idx += 1
            ans[start:idx + 1] = ans[start:idx+1][::-1]
        return "".join(ans)