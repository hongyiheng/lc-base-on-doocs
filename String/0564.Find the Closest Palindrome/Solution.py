class Solution:
    def nearestPalindromic(self, n: str) -> str:
        m, num, nums = len(n), int(n), set()
        nums.add(pow(10, m) + 1)
        nums.add(pow(10, m - 1) - 1)
        mid = int(n[0:(m + 1) // 2])
        for i in range(mid - 1, mid + 2):
            tmp = str(i)
            idx = len(tmp) - 1 if m % 2 == 0 else len(tmp) - 2
            while idx >= 0:
                tmp += tmp[idx]
                idx -= 1
            if int(tmp) != num:
                nums.add(int(tmp))
        ans = -1
        for v in nums:
            if ans == -1:
                ans = v
            elif abs(v - num) < abs(ans - num):
                ans = v
            elif abs(v - num) == abs(ans - num) and v < ans:
                ans = v
        return str(ans)