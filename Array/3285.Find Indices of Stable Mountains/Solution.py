class Solution:
    def stableMountains(self, height: List[int], threshold: int) -> List[int]:
        ans = []
        for i in range(len(height) - 1):
            if height[i] > threshold:
                ans.append(i + 1)
        return ans