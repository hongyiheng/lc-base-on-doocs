class Solution:
    def prevPermOpt1(self, arr: List[int]) -> List[int]:
        mp = dict()
        n = len(arr)
        for i in range(n - 1, -1, -1):
            for j in range(arr[i] - 1, -1, -1):
                if j in mp:
                    arr[i], arr[mp[j]] = arr[mp[j]], arr[i]
                    return arr
            mp[arr[i]] = i
        return arr
