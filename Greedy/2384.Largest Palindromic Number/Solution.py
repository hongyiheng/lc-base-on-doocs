class Solution:
    def largestPalindromic(self, num: str) -> str:
        cnt = [0] * 10
        for c in num:
            cnt[ord(c) - ord('0')] += 1
        nums = []
        for i in range(9, -1, -1):
            if not nums and i == 0:
                break
            for _ in range(cnt[i] // 2):
                nums.append(str(i))
            cnt[i] %= 2
        ans = "".join(nums)
        for i in range(9, -1, -1):
            if cnt[i]:
                ans += str(i)
                break
        ans += "".join(nums)[::-1]
        return ans