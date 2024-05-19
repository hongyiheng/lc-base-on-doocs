class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        mx, cur, cnt = arr[0], arr[0], 0
        for i in range(1, len(arr)):
            if cur >= arr[i]:
                cnt += 1
            else:
                mx = cur = arr[i]
                cnt = 1
            if cnt >= k:
                return cur
        return mx