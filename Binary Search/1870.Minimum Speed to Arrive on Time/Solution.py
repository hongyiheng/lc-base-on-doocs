class Solution:
    def minSpeedOnTime(self, dist: List[int], hour: float) -> int:
        m = len(dist)

        def check(speed):
            cost = 0
            for i in range(m):
                temp = dist[i] * 1.00 / speed
                if i != m - 1:
                    cost += math.ceil(temp)
                else:
                    cost += temp
            return cost <= hour

        if m > math.ceil(hour):
            return -1
        left, right = 1, max(max(dist), 1e7)
        while left < right:
            mid = (left + right) // 2
            if check(mid):
                right = mid
            else:
                left = mid + 1
        return int(left)
