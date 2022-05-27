class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        nums = []
        for i, w in enumerate(wordsDict):
            if w == word1:
                nums.append(i)
        ans = len(wordsDict)
        for i, w in enumerate(wordsDict):
            if w == word2:
                left, right = 0, len(nums) - 1
                while left < right:
                    mid = (left + right) >> 1
                    if nums[mid] < i:
                        left = mid + 1
                    else:
                        right = mid
                if left > 0 and abs(nums[left - 1] - i) < abs(nums[left] - i):
                    left = left - 1
                ans = min(ans, abs(nums[left] - i))
        return ans