class Solution:
    def largeGroupPositions(self, s: str) -> List[List[int]]:
        ans = []
        left = right = 0
        n = len(s)
        while right < n:
            if s[right] != s[left]:
                if right - left >= 3:
                    ans.append([left, right - 1])
                left = right
            right += 1
        if right - left >= 3:
            ans.append([left, right - 1])
        return ans