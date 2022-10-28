class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        n = len(arr)
        l, r = [-1] * n, [n] * n
        q = deque()
        for i in range(n):
            while q and arr[q[-1]] >= arr[i]:
                r[q.pop()] = i
            q.append(i)
        q.clear()
        for i in range(n - 1, -1, -1):
            while q and arr[q[-1]] > arr[i]:
                l[q.pop()] = i
            q.append(i)
        ans = 0
        for i in range(n):
            a, b = l[i], r[i]
            ans += (i - a) * (b - i) * arr[i]
            ans %= int(1e9 + 7)
        return ans
