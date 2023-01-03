class Solution:
    def areNumbersAscending(self, s: str) -> bool:
        last = -1
        for w in s.split(" "):
            if '0' <= w[0] <= '9':
                cur = int(w)
                if cur <= last:
                    return False
                last = cur
        return True