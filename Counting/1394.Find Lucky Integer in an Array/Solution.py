class Solution:
    def findLucky(self, arr: List[int]) -> int:
        cnt = Counter(arr)
        ans = max([k if cnt[k] == k else 0 for k in cnt.keys()])
        return -1 if not ans else ans
