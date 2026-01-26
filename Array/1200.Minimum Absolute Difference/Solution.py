class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        arr.sort()
        ans = []
        mi = arr[1] - arr[0]
        for i in range(len(arr) - 1):
            d = arr[i + 1] - arr[i]
            if d == mi:
                ans.append([arr[i], arr[i + 1]])
            elif d < mi:
                mi = d
                ans = [[arr[i], arr[i + 1]]]
        return ans