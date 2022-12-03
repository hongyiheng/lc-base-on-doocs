class Solution:
    def secondHighest(self, s: str) -> int:
        nums = [False] * 10
        for c in s:
            if '0' <= c <= '9':
                nums[ord(c) - ord('0')] = True
        flag = False
        for i in range(9, -1, -1):
            if nums[i]:
                if flag:
                    return i
                flag = True
        return -1
