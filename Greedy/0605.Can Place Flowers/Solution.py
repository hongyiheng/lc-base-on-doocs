class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        m = len(flowerbed)
        cnt = 0
        for i in range(m):
            if flowerbed[i]:
                continue
            if not flowerbed[max(i - 1, 0)] and not flowerbed[min(m - 1, i + 1)]:
                flowerbed[i] = 1
                cnt += 1
        return cnt >= n