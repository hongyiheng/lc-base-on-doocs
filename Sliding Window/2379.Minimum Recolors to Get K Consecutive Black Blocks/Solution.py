class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        l = r = 0
        ans, n, b = k, len(blocks), 0
        while r < n:
            if blocks[r] == 'B':
                b += 1
            if r - l + 1 > k:
                b -= 1 if blocks[l] == 'B' else 0
                l += 1
            ans = min(ans, k - b)
            r += 1
        return ans