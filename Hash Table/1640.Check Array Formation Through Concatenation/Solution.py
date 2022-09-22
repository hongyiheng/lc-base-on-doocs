class Solution:
    def canFormArray(self, arr: List[int], pieces: List[List[int]]) -> bool:
        mp = dict()
        for v in pieces:
            mp[v[0]] = v
        idx, n = 0, len(arr)
        while idx < n:
            if arr[idx] not in mp:
                return False
            nums = mp.pop(arr[idx])
            for v in nums:
                if v == arr[idx]:
                    idx += 1
                else:
                    return False
        return True
