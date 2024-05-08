class Solution:
    def wateringPlants(self, plants: List[int], capacity: int) -> int:
        ans, cur = 0, capacity
        for i, v in enumerate(plants):
            if cur < v:
                ans += i * 2
                cur = capacity
            cur -= v
            ans += 1
        return ans