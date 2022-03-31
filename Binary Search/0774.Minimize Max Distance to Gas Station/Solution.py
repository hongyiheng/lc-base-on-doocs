class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        left, right = 0, len(letters) - 1
        while left < right:
            mid = (left + right) >> 1
            if letters[mid] <= target:
                left = mid + 1
            else:
                right = mid
        return letters[left] if letters[left] > target else letters[0]