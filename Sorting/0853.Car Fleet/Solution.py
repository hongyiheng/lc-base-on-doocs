class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        ts = dict()
        for p, s in zip(position, speed):
            ts[p] = (target - p) / s
        position.sort()
        ans, slow = 0, -1
        for i in range(len(position) - 1, -1, -1):
            if ts[position[i]] > slow:
                ans += 1
                slow = ts[position[i]]
        return ans