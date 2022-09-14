class Solution:
    def trimMean(self, arr: List[int]) -> float:
        arr.sort()
        n, ans, cnt = len(arr), 0, 0
        for i in range(int(n * 0.05), int(n * 0.95)):
            ans += arr[i]
            cnt += 1
        return ans / cnt