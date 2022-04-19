class Solution:
    def hIndex(self, citations: List[int]) -> int:
        left, right = 0, len(citations)
        while left < right:
            mid = (left + right + 1) >> 1
            if citations[-mid] >= mid:
                left = mid
            else:
                right = mid - 1
        return left