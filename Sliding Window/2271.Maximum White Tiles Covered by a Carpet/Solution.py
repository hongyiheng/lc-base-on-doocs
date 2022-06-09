class Solution:
    def maximumWhiteTiles(self, tiles: List[List[int]], carpetLen: int) -> int:
        tiles.sort(key=lambda x:x[0])
        n, l, r = len(tiles), 0, 0
        cur, ans = 0, 0
        while l <= r and r < n:
            left, right = tiles[l][0], tiles[l][0] + carpetLen - 1
            if tiles[r][1] <= right:
                cur += tiles[r][1] - tiles[r][0] + 1
                ans = max(ans, cur)
                r += 1
            else:
                if tiles[r][0] <= right:
                    ans = max(ans, cur + right - tiles[r][0] + 1)
                cur -= tiles[l][1] - tiles[l][0] + 1
                l += 1
        return ans