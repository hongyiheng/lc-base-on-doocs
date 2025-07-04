class Solution:
    def kthCharacter(self, k: int, operations: List[int]) -> str:
        m = 0
        while 1 << m < k:
            m += 1
        pos = k
        cnt = 0
        while m > 0:
            half = 1 << (m - 1)
            if pos > half:
                pos -= half
                if operations[m - 1]:
                    cnt += 1
            m -= 1
        return chr(cnt % 26 + ord('a'))