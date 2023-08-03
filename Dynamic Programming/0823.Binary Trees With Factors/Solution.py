class Solution:
    def numFactoredBinaryTrees(self, arr: List[int]) -> int:
        n = len(arr)
        arr.sort()
        mp = dict()
        for v in arr:
            mp[v] = 1
        for i in range(n):
            a = arr[i]
            for j in range(i, -1, -1):
                b = arr[j]
                if a % b != 0 or a // b > b:
                    continue
                if a // b in mp.keys():
                    mp[a] += mp[b] * mp[b] if a == b * b else mp[b] * mp[a // b] * 2
        ans = sum(mp.values())
        return ans % int(1e9 + 7)