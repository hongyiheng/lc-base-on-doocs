class Solution:
    def maxDistance(self, position: List[int], m: int) -> int:
        def check(position, x, m):
            last = position[0]
            m -= 1
            for i in range(1, len(position)):
                if position[i] - last >= x:
                    last = position[i]
                    m -= 1
                    if m <= 0:
                        return True
            return False

        position.sort()
        left, right = 0, (position[-1] - position[0]) // (m - 1)
        while left < right:
            mid = (left + right + 1) >> 1
            if check(position, mid, m):
                left = mid
            else:
                right = mid - 1
        return left
