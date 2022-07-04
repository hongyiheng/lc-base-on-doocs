class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        ans = []
        arr.sort()
        min_val = float('inf')
        for i in range(1, len(arr)):
            cur = abs(arr[i - 1] - arr[i])
            if min_val >= cur:
                if min_val > cur:
                    min_val = cur
                    ans.clear()
                ans.append([arr[i - 1], arr[i]])
        return ans